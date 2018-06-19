package com.github.gabrielbb.algorithms.sort.impl;

import com.github.gabrielbb.algorithms.sort.Sortable;

public class BubbleSort implements Sortable {

    private void swap(int[] array, int one, int two) {
        if (array[one] > array[two]) {
            int temp = array[one];

            array[one] = array[two];
            array[two] = temp;
        }
    }

    public void sort(int[] array) {
        for (int out = array.length - 1; out > 1; out--)
            for (int i = 0; i < out; i++)
                swap(array, i, i + 1);
    }
}
