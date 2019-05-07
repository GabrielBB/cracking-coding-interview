package com.github.gabrielbb.ctci.hard;

import java.util.Random;

public class RandomSet {

    public static int[] generateSubSet(int[] array, int subsetLength) {

        var random = new Random();
        var subSet = new int[subsetLength];

        int subsetIndex = 0;

        for(int i = array.length - 1; i >= 0 && subsetIndex < subSet.length; i--, subsetIndex++) {

            int chosen = random.nextInt(i + 1);
            subSet[subsetIndex] = array[chosen];
            array[chosen] = array[i];
        }

        return subSet;
    }
}