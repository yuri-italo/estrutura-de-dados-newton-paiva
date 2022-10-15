package br.newtonpaiva.av1.pergunta3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Pergunta3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<PostRedeSocial> postsRedeSocial = new ArrayDeque<>();
        int opcao = Integer.MAX_VALUE;

        while (opcao != 3) {
            System.out.println("<1> Cadastrar Post");
            System.out.println("<2> Visualizar Post Relevantes");
            System.out.println("<3> Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            System.out.println();

            if (opcao < 1 || opcao > 3)
                System.out.println("Comando Inválido!");

            if (opcao == 1) {
                System.out.print("Mensagem: ");
                String mensagem = sc.nextLine();

                byte relevancia = Byte.MIN_VALUE;
                while (relevancia <= 0) {
                    System.out.print("Relevância: ");
                    relevancia = sc.nextByte();
                    System.out.println();
                }

                if (relevancia == 1)
                    postsRedeSocial.addFirst(new PostRedeSocial(mensagem,relevancia));
                else
                    postsRedeSocial.addLast(new PostRedeSocial(mensagem,relevancia));
            }

            if (opcao == 2) {
                List<PostRedeSocial> relevantes = postsRedeSocial.stream()
                        .filter(postRedeSocial -> postRedeSocial.getRelevancia() == 1)
                        .toList();

                relevantes.forEach(System.out::println);
                System.out.println();
            }
        }
    }
}
