package com.github.gabrielbb.algorithms.sort.impl;

import com.github.gabrielbb.algorithms.sort.Sortable;

public class BubbleSort implements Sortable {

    public void sort(int[] array) {
        boolean sorted = true;

        while (sorted) {
            sorted = false;
            for (int i = 1; i < array.length; i++) {

                if (array[i] < array[i - 1]) {
                    int temp = array[i - 1];

                    array[i - 1] = array[i];
                    array[i] = temp;
                    sorted = true;
                }
            }
        }

    }
}
