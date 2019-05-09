package com.github.gabrielbb.ctci.hard;

public class NumberOf2s {

    public static int getNumberOf2s(int n) {

        int digits = getNumberOfDigits(n);

        

        return -1;
    }

    private static int getNumberOfDigits(int n) {

        int digits = 1;

        while (n > 10) {
            n /= 10;
        }

        return digits;
    }
}