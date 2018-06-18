package com.github.gabrielbb.algorithms.search.impl;

import com.github.gabrielbb.algorithms.search.Searchable;

public class BinarySearch implements Searchable {

    public int find(int[] array, int key) {
        int start = 0;
        int end = array.length - 1;
        int currentIndex;

        while (start <= end) {
            currentIndex = (start + end) / 2;
            
            if(array[currentIndex] == key) return currentIndex;
            
            if(array[currentIndex] > key) {
                end = currentIndex - 1;
            } else {
                start = currentIndex + 1;
            }
        }

        return -1;
    }
}
