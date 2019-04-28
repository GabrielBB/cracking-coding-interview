package com.github.gabrielbb.algorithms.assignments.hard;

public class AddWithoutPlus {

    public static int add(int a, int b) {

        int result = 0;
        boolean remaining = false;

        for (int i = 0; i < 32; i++) {

            boolean aBit = getBit(a, i);
            boolean bBit = getBit(b, i);

            if (aBit ^ bBit && !remaining || ((!aBit && !bBit) && remaining)) {
                result = setBit(result, i);
                remaining = false;
                continue;
            }

            if (aBit && bBit) {
                if (remaining) {
                    result = setBit(result, i);
                } else {
                    remaining = true;
                }
            }
        }

        return result;
    }

    private static int setBit(int num, int index) {
        return num | (1 << index);
    }

    private static boolean getBit(int num, int index) {
        return (num & (1 << index)) != 0;
    }

}