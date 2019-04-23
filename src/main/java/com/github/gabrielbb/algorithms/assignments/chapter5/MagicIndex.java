package com.github.gabrielbb.algorithms.assignments.chapter5;

public class MagicIndex {

    public int getMagicIndex(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i == array[i])
                return i;
        }

        return -1;
    }
};