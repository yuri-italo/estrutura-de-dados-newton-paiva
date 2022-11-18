package br.newtonpaiva.tarefa8;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static Scanner sc;

    public static void main(String[] args) throws FileNotFoundException {
        int opcao;
        String path = "src/br/newtonpaiva/tarefa8/Dataset_Supermercados.csv";
        Map<String, TreeMap<String, Produto>> produtosPorCategoria = getProdutosPorCategoria(path);
        sc = new Scanner(System.in);

        do {
            System.out.println("            DATASET SUPERMERCADOS            ");
            System.out.println("*********************************************");
            System.out.println("Escolha uma opcao:");
            System.out.println("----1: Pesquisar Produto");
            System.out.println("----2: Visualizar Produtos por Categoria");
            System.out.println("----3: Excluir Produto");
            System.out.println("----4: Sair");
            System.out.println("*********************************************");
            System.out.print("-> ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    String categoria = selecionarCategoria(produtosPorCategoria);
                    Produto produto = selecionarProdutoNaCategoria(categoria,produtosPorCategoria);

                    if (produto == null)
                        System.out.println("\nCódigo inexistente na cateogira selecionada.\n");
                    else
                        System.out.println("\n" + produto + "\n");
                    break;
                case 2:
                    categoria = selecionarCategoria(produtosPorCategoria);
                    System.out.println("\nProdutos cadastrados na categoria: " + categoria);
                    produtosPorCategoria.get(categoria).forEach((k,v) -> System.out.println(
                        "---------------------------------------------" + "\n" +
                        "id=" + v.getId() + "\n" +
                        "title=" + v.getTitle() + "\n" +
                        "brand=" + v.getBrand() + "\n" +
                        "normalPrice=" + v.getNormalPrice() + "\n" +
                        "dateTime=" + v.getDateTime() + "\n" +
                        "kilo=" + v.getKilo() + "\n"
                    ));
                    break;
                case 3:
                    categoria = selecionarCategoria(produtosPorCategoria);
                    produto = selecionarProdutoNaCategoria(categoria,produtosPorCategoria);

                    if (produto == null)
                        System.out.println("\nProduto Inexistente.\n");
                    else
                        removerProduto(categoria,produto,produtosPorCategoria);
                    break;
                case 4:
                    System.out.println("Volte sempre =)");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);

        sc.close();
    }

    private static Map<String, TreeMap<String,Produto>> getProdutosPorCategoria(String filePath) throws FileNotFoundException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        Map<String, TreeMap<String,Produto>> produtosPorCategoria = new TreeMap<>();
        Produto produto;
        sc = new Scanner(new File(filePath));

        sc.nextLine(); // saltar cabecalho

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(",");
            produto = new Produto(
                    split[0],split[1],Double.valueOf(split[2]),Double.valueOf(split[3]),Double.valueOf(split[4]),
                    Integer.valueOf(split[5]),split[6],split[7], LocalDateTime.parse(split[8], formatter),split[9],
                    Integer.valueOf(split[10]),Integer.valueOf(split[11]),Double.valueOf(split[12]),
                    Double.valueOf(split[13]),Double.valueOf(split[14])
            );
            // adicionar categoria e arvore, caso nao existir
            produtosPorCategoria.computeIfAbsent(produto.getCategoria2(), k -> new TreeMap<>());
            // definir id do produto (4 primeiras letras da categoria + numeração sequencial)
            produto.setId(produtosPorCategoria.get(produto.getCategoria2()).size());
            // adicionar produto na arvore da categoria, definindo id do produto como key para o produto
            produtosPorCategoria.get(produto.getCategoria2()).put(produto.getId(),produto);
        }

        return produtosPorCategoria;
    }

    private static String selecionarCategoria(Map<String, TreeMap<String, Produto>> produtosPorCategoria) {
        int qtt = 0;
        int opcao;

        List<String> categorias = new ArrayList<>();
        produtosPorCategoria.forEach((k,v) -> categorias.add(k));

        System.out.println("                  CATEGORIAS                 ");
        System.out.println("*********************************************");
        for (var categoria : categorias)
            System.out.println(qtt++ + " -> " + categoria);
        System.out.println("*********************************************");

        while (true) {
            System.out.print("-> ");
            opcao = sc.nextInt();
            if (opcao < 0 || opcao >= categorias.size())
                continue;

            break;
        }

        return categorias.get(opcao);
    }

    private static Produto selecionarProdutoNaCategoria(
            String categoria, Map<String, TreeMap<String, Produto>> produtosPorCategoria
    ) {
        long codProduto;

        while (true) {
            System.out.print("Código do Produto -> " + categoria.substring(0,4).toUpperCase());
            codProduto = sc.nextLong();

            if (codProduto < 0)
                continue;

            break;
        }

        return produtosPorCategoria.get(categoria).get(categoria.substring(0,4).toUpperCase() + codProduto);
    }

    private static void removerProduto(
            String categoria, Produto produto, Map<String, TreeMap<String, Produto>> produtosPorCategoria
    ) {
        produtosPorCategoria.get(categoria).remove(produto.getId());
        System.out.println("\n" + "Produto Excluído com Sucesso." + "\n");
    }
}
