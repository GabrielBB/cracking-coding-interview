package com.github.gabrielbb.ctci.chapter1;

import java.util.LinkedList;

public class ZeroMatrix {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void convert(int[][] matrix) {

        final var points = new LinkedList<Point>();

        for (int y = 0; y < matrix.length; y++) {

            int[] row = matrix[y];

            for (int x = 0; x < row.length; x++) {

                if (row[x] == 0) {
                    points.add(new Point(x, y));
                }
            }
        }

        points.forEach(p -> drawZeros(matrix, p));
    }

    private static void drawZeros(int[][] matrix, Point p) {
        for (int i = 0; i < matrix.length; i++) {

            matrix[i][p.x] = 0;
            matrix[p.y][i] = 0;
        }
    }
}