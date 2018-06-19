package com.github.gabrielbb.algorithms.sort.impl;

import com.github.gabrielbb.algorithms.sort.Sortable;

public class InsertionSort implements Sortable {

    public void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int temp = array[i];
            int curIn = i;

            while (curIn > 0 && array[curIn - 1] > temp) {
                array[curIn] = array[curIn - 1];
                curIn--;
            }

            array[curIn] = temp;
        }
    }
}