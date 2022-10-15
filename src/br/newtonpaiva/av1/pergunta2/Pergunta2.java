package br.newtonpaiva.av1.pergunta2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Pergunta2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc;
        Stack<String> pilha1 = new Stack<>();
        Stack<String> pilha2 = new Stack<>();
        Stack<String> pilha3 = new Stack<>();

        sc = new Scanner(new File("./pilha1.txt"));
        while (sc.hasNextLine())
            pilha1.push(sc.nextLine());

        sc = new Scanner(new File("./pilha2.txt"));
        while (sc.hasNextLine())
            pilha2.push(sc.nextLine());

        sc = new Scanner(new File("./pilha3.txt"));
        while (sc.hasNextLine())
            pilha3.push(sc.nextLine());

        while (!pilha3.isEmpty()) {
            System.out.println("Assistente 1 - prato: " + pilha1.pop());
            System.out.println("Assistente 2 - prato: " + pilha2.pop());
            System.out.println("Assistente 3 - prato: " + pilha3.pop());
        }

    }
}
