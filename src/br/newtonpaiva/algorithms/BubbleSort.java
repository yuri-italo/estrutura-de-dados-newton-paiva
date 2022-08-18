package br.newtonpaiva.algorithms;

public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length -1; j++)
                if (array[j] > array[j+1])
                    swap(array, j);
    }

    private static void swap(int[] array, int j) {
        var aux = array[j];
        array[j] = array[j +1];
        array[j +1] = aux;
    }
}
