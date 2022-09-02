package br.newtonpaiva.pratica1;

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Placa do carro: ");
        String placa = scanner.next().toLowerCase();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        if (ano < 2010)
            System.out.println("Carro Velho");
        else if (ano <= 2021)
            System.out.println("Carro Semi Novo");
        else
            System.out.println("Carro Novo");

        String vogais = "aeiou";
        String placaSemVogal = placa;

        for (int i = 0; i < placa.length(); i++) {
            String indexValue = String.valueOf(placa.charAt(i));
            if (vogais.contains(indexValue))
                placaSemVogal = placa.replace(placa.charAt(i),'*');
        }

        System.out.println(placaSemVogal);
        scanner.close();
    }
}
