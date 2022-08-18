package br.newtonpaiva.tarefa1;

import java.util.Random;
import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        int left = 0;
        int[] numbers = new int[50];
        int right = numbers.length -1;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.print("Vetor Randômico: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(99);
            System.out.print(numbers[i] + "\t");
        }

        System.out.print("\nBubble Sort: ");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    var aux = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = aux;
                }
            }
        }

        for (var number : numbers)
            System.out.print(number + "\t");

        System.out.print("\nQual número deseja encontrar? ");
        int target = scanner.nextInt();

        while (left <= right) {
            var middle = (left + right) / 2;

            if (numbers[middle] == target) {
                System.out.printf("O número %d foi encontrado no índice %d.\n",target,middle);
                break;
            }

            if (numbers[middle] > target)
                right = middle -1;
            else
                left = middle + 1;
        }

        if (left > right)
            System.out.printf("O número %d não foi encontrado.\n",target);
    }
}
