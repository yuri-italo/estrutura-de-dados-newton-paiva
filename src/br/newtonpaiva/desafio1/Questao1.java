package br.newtonpaiva.desafio1;

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
public class Questao1 {
    public static void main(String[] args) throws FileNotFoundException {
        DoublyLinkedList listaNoiva = new DoublyLinkedList();
        DoublyLinkedList listaNoivo = new DoublyLinkedList();
        DoublyLinkedList listaNoivoENoiva = new DoublyLinkedList();
        Scanner scanner;

        scanner = new Scanner(new File("./lista-noiva.txt"));
        while (scanner.hasNextLine()){
            listaNoiva.insertLast(scanner.nextLine());
        }

        scanner = new Scanner(new File("./lista-noivo.txt"));
        while (scanner.hasNextLine()){
            listaNoivo.insertLast(scanner.nextLine());
        }
        scanner.close();

        for (int i = 0; i < listaNoiva.length(); i++) {
            listaNoivoENoiva.insertLast(listaNoiva.getNodeData(i));
            if (i < listaNoivo.length())
                listaNoivoENoiva.insertLast(listaNoivo.getNodeData(i));
        }

        listaNoivoENoiva.sortList();

        System.out.println("Lista Completa em ordem alfabética: ");
        listaNoivoENoiva.displayForward();
    }
}
