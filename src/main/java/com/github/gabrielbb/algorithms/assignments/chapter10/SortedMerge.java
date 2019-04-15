package com.github.gabrielbb.algorithms.assignments.chapter10;

public class SortedMerge {

    public static void sort(int[] a, int[] b) {
        mergeSort(a, b, a.clone());
    }

    private static void mergeSort(int[] a, int[] b, int[] helper) {

        int current = 0;
        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < (a.length - b.length) && bIndex < b.length) {

            if (b[bIndex] < helper[aIndex]) {
                a[current] = b[bIndex];
                bIndex++;
            } else {
                a[current] = helper[aIndex];
                aIndex++;
            }

            current++;
        }

        /* Copy the rest of values in a and b to a*/
        
        while(aIndex < (a.length - b.length)) {
            a[current] = helper[aIndex];
            aIndex++;
            current++;
        }

        while(bIndex < b.length) {
            a[current] = b[bIndex];
            bIndex++;
            current++;
        }
    }
}