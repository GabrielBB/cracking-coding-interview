package com.github.gabrielbb.ctci.chapter1;

public class MatrixRotation {

    public static int[][] rotate(int[][] matrix) {

        int size = matrix.length;

        final int[][] newMatrix = new int[size][size];

        for(int y = size - 1; y >= 0; y--) {

            int[] row = matrix[y];

            for(int x = 0; x < row.length; x++) {
                
                int inverseY = (size - 1) - y;

                newMatrix[x][inverseY] = row[x];
            }
        }

        return newMatrix;
    }
}