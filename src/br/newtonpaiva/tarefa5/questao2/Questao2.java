package br.newtonpaiva.tarefa5.questao2;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/*
    Elabore um programa que utilize o TAD Doquer para adicionar objetos de uma classe contendo os seguintes atributos:
    Nome, telefone e e-mail. O programa deve solicitar os dados de 10 pessoas. Ao final imprimir a lista na ordem
    convencional e na ordem inversa.
*/

public class Questao2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Pessoa> pesssoas = new LinkedBlockingDeque<>(10);
        Deque<Pessoa> pesssoasAux = new LinkedBlockingDeque<>(10);

        for (int i = 0; i < 10; i++) {
            System.out.println("Cadastro: Pessoa " + (i + 1));
            System.out.print("Digite o nome: ");
            String nome = sc.nextLine();
            System.out.print("Digite o telefone: ");
            String telefone = sc.nextLine();
            System.out.print("Digite o email: ");
            String email = sc.nextLine();

            pesssoas.addLast(new Pessoa(nome,telefone,email));
            System.out.println("--------------------------------");
        }

        System.out.println("ORDEM CONVENCIONAL");
        while (!pesssoas.isEmpty()) {
            pesssoasAux.addLast(pesssoas.getFirst());
            System.out.println(pesssoas.removeFirst());
        }
        System.out.println("--------------------------------");

        System.out.println("ORDEM INVERSA");
        while (!pesssoasAux.isEmpty())
            System.out.println(pesssoasAux.removeLast());

        sc.close();
    }
}
