package br.newtonpaiva.tarefa3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*

    Implemente uma pilha que leia um arquivo de texto contendo frases
    buscadas em um software, como uma lista de frases de busca do
    Google.

    • O programa deverá empilhar todo conteúdo em uma estrutura de pilha.
    • Mostrar as top 10 frases mais buscadas por último
    • Desempilhar o restante dos dados depois da 10ª frase.

*/
public class Questao1 {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<String> frases = new Stack<>();
        Queue<String> top10Frases = new LinkedList<>();
        Scanner scanner;

        scanner = new Scanner(new File("./frases.txt"));
        while (scanner.hasNextLine())
            frases.add(scanner.nextLine());

        if (!frases.isEmpty()) {
            while (top10Frases.size() < 10)
                top10Frases.add(frases.pop());

            System.out.println("Frases depois da decima:");
            while (!frases.empty())
                System.out.println(frases.pop());

            System.out.println("-----------------------------------");
            System.out.println("Top 10 frases:");
            top10Frases.forEach(System.out::println);
        } else
            System.out.println("Não existem frases buscadas.");
    }
}
