package br.newtonpaiva.tarefa2.questao2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    Um casal está fazendo a lista de convidados para o seu casamento. A
    noiva possui uma lista com 60 convidados e o noivo com 55 convidados.
    Implemente um algoritmo que crie uma lista para cada um (noivo e
    noiva). Em seguida faça a união das listas e imprima o nome de cada
    convidado por ordem alfabética.
 */
public class Questao2 {
    public static void main(String[] args) throws FileNotFoundException {
        ListaLigada listaNoiva = new ListaLigada();
        ListaLigada listaNoivo = new ListaLigada();
        ListaLigada listaNoivoENoiva = new ListaLigada();
        Scanner scanner;

        scanner = new Scanner(new File("./lista-noiva.txt"));
        while (scanner.hasNextLine()){
            listaNoiva.adicionar(scanner.nextLine());
        }

        scanner = new Scanner(new File("./lista-noivo.txt"));
        while (scanner.hasNextLine()){
            listaNoivo.adicionar(scanner.nextLine());
        }
        scanner.close();

        for (int i = 0; i < listaNoiva.getTamanho(); i++) {
            listaNoivoENoiva.adicionar(listaNoiva.get(i).getValor());
            if (i < listaNoivo.getTamanho())
                listaNoivoENoiva.adicionar(listaNoivo.get(i).getValor());
        }

        BubbleSortListaLigada bubbleSort = new BubbleSortListaLigada();
        bubbleSort.sort(listaNoivoENoiva);

        System.out.println("Lista Completa em ordem alfabética: ");
        for (int i = 0; i < listaNoivoENoiva.getTamanho(); i++) {
            System.out.println(listaNoivoENoiva.get(i).getValor());
        }
    }
}
