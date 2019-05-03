package com.github.gabrielbb.practicing.sorting.impl;

import com.github.gabrielbb.practicing.sorting.Sortable;

public class MergeSort implements Sortable {

    @Override
    public void sort(int[] array) {
        mergeSort(array, array.clone(), 0, array.length - 1);
    }

    private void mergeSort(int[] array, int[] helper, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, helper, start, middle);
            mergeSort(array, helper, middle + 1, end);

            merge(array, helper, start, middle, end);
        }

    }

    void merge(int[] array, int[] helper, int low, int middle, int end) {

        int current = low;
        int helperLeft = low;
        int helperRight = middle + 1;

        /*
         * Iterate through helper array. Compare the left and right half, copying back
         * the smaller element from the two halves into the original array.
         */
        while (helperLeft <= middle && helperRight <= end) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the target array */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}