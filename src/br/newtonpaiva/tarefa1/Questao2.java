package br.newtonpaiva.tarefa1;

import java.util.Random;

/*
    Faça um programa que preencha uma matriz mat 3 x 4 de
    inteiros randômicos. Descobrir o maior e menor elemento da
    matriz.
    Exibir a matriz (use a tabulação) e também o menor e maior
    elemento.
 */
public class Questao2 {
    public static void main(String[] args) {
        Random random = new Random();
        int greater = Integer.MIN_VALUE;
        int smaller = Integer.MAX_VALUE;
        int[][] mat = new int[3][4];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = random.nextInt(100);

                if (mat[i][j] < smaller)
                    smaller = mat[i][j];

                if (mat[i][j] > greater)
                    greater = mat[i][j];

                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("Menor elemento: " + smaller);
        System.out.println("Maior elemento: " + greater);
    }
}
