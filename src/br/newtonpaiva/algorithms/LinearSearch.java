package br.newtonpaiva.algorithms;

public class LinearSearch {
    public int find(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == number)
                return i;

        return -1;
    }
}
