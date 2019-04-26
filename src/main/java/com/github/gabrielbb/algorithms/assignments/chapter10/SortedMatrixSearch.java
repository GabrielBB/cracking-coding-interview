package com.github.gabrielbb.algorithms.assignments.chapter10;

import java.util.Arrays;

public class SortedMatrixSearch {

    public static int[] search(int[][] matrix, int num) {

        int from = 0;
        int to = matrix[0].length;

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {

            int columnIndex = Arrays.binarySearch(matrix[rowIndex], from, to, num);

            if (columnIndex < 0) {

                if (columnIndex == -1) {
                    break;
                }

                to = (columnIndex + 1) * -1;
            } else {
                return new int[] { rowIndex, columnIndex };
            }
        }

        return null;
    }
}