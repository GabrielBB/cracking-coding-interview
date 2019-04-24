package com.github.gabrielbb.algorithms.assignments.chapter5;

public class Insertion {

    public static int insert(int n, int m, int i, int j) {
        int right = n & (1 << i) - 1;
        int left = n & (~0 << i + j);

        System.out.println("N: " + Integer.toBinaryString(right));
        System.out.println("N: " + Integer.toBinaryString(left));

        return left | (m << i) | right;
    }
}