package com.github.gabrielbb.ctci.chapter1;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    public static boolean isPalondrimePermutation(String text) {

        if (text.isEmpty() || text.length() == 1) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();
        boolean previouslyFoundOdd = false;

        text = text.toLowerCase();
        char[] chars = text.toCharArray();

        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                count.put(c, count.containsKey(c) ? count.get(c) + 1 : 1);
            }

        }

        for (int val : count.values()) {
            if (val % 2 != 0) {

                if (previouslyFoundOdd) {
                    return false;
                }

                previouslyFoundOdd = true;
            }
        }

        return true;
    }
}