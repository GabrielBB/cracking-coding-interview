package com.github.gabrielbb.algorithms.assignments.chapter5;

/*
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation
 */
public class NextNumber {

    public static int findLargestNextNumber(int num) {

        if(num == 0 || num == ~0) {
            return num;
        }

        int last1Index = -1;

        for (int i = 0; i < 32; i++) {

            if (getBit(num, i)) {
                last1Index = i;
                continue;
            }

            if(last1Index >= 0) {
                num = setBit(num, i);
                num = clearBit(num, last1Index);
                break;
            }
        }

        return num;
    }

    private static boolean getBit(int num, int index) {
        return (num & (1 << index)) != 0;
    }

    private static int setBit(int num, int index) {
        return num | (1 << index);
    }

    private static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
}