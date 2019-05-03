package com.github.gabrielbb.ctci.chapter10;

public class FindDuplicates {

    public static void printDuplicates(int[] nums) {

        boolean[] status = new boolean[32000];

        for (int i : nums) {
            if (status[i]) {
                System.out.println(i + " was already in the array before");
            }
            status[i] = !status[i];
        }
    }
}