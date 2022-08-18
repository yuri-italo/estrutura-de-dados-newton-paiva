package br.newtonpaiva.tarefa1;

import java.util.Random;
import java.util.Scanner;

/*
    Busca Sequencial: Fazer um programa que insira 10 valores inteiros randômicos
    em um vetor, mostre o vetor e busque um determinado elemento (mostrar a
    posição que encontrou). Caso não exista imprimir mensagem de não localizado.
*/

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] numbers = new int[10];
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
            System.out.print(numbers[i] + "\t");
        }

        System.out.print("\nNúmero para ser encontrado: ");
        int number = scanner.nextInt();

        for (int i = 0; i < numbers.length; i++) {
            if (number == numbers[i]) {
                found = true;
                System.out.printf("O número %d foi encontrado na posição %d\n",number,i);
            }
        }

        if (!found)
            System.out.printf("O número %d não foi encontrado.\n",number);
    }
}
