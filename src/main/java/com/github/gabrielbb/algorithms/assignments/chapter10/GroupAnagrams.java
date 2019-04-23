package com.github.gabrielbb.algorithms.assignments.chapter10;

import java.util.Arrays;

public class GroupAnagrams {

    public static void sort(String[] array) {

        if (array.length <= 2) {
            return;
        }

        int curr = 0;

        while (true) {

            int swapIndex = getSwapIndex(array, curr);

            if (swapIndex == -1)
                break;

            for (int i = swapIndex + 1; i < array.length; i++) {

                if (isAnagram(array[i], array[curr])) {
                    swap(array, i, swapIndex);
                    break;
                }
            }

            curr = swapIndex;
        }
    }

    private static void swap(String[] array, int a, int b) {
        String temp = array[a];

        array[a] = array[b];
        array[b] = temp;
    }

    private static int getSwapIndex(String[] array, int stringIndex) {

        for (int i = stringIndex + 1; i < array.length; i++)
            if (!isAnagram(array[i], array[stringIndex]))
                return i;

        return -1;
    }

    private static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        for (int i = 0; i < s1Chars.length; i++)
            if (s1Chars[i] != s2Chars[i])
                return false;

        return true;
    }
}