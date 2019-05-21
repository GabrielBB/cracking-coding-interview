package com.github.gabrielbb.practicing;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];

        for(int[] query : queries) {
            array[query[0] - 1] += query[2];

            if(query[1] < n) {
                array[query[1]] += (query[2] * -1);
            }
           
        }

        long max = 0;
        long currentVal = 0;

        for(int i = 0; i < n; i++) {
            currentVal += array[i];
            if(currentVal > max) {
                max = currentVal;
            }
        }

        //System.out.println(Arrays.toString(array));

        //System.out.println(max);
        return max;
    }
}
