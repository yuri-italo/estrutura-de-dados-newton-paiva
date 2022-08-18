package br.newtonpaiva.algorithms;

public class BinarySearch {
    public int find(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (array[middle] > target)
                right = middle -1;
            else
                left = middle +1;
        }

        return -1;
    }
}
