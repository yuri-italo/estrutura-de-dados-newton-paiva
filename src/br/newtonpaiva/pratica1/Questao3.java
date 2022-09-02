package br.newtonpaiva.pratica1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Questao3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String vogais = "aeiouáéíóú";
        int quantidade = 0;
        Set<Character> fraseDistinta = new HashSet<>();

        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine().toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            fraseDistinta.add(frase.charAt(i));
        }

        for (var letra : fraseDistinta) {
            if (vogais.contains(String.valueOf(letra)))
                quantidade++;
        }

        System.out.println("Quantidade de vogais: " + quantidade);
    }
}
