package com.github.gabrielbb.ctci.chapter5;

public class FlipBitToWin {

    public static int findLongest1Sequence(int num) {

        int count = 0;
        int max = 0;

        for (int i = 1; i < 32; i++) {

            if ((num & (1 << i)) != 0) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
            }
        }

        return max;
    }
}