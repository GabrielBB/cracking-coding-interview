package com.github.gabrielbb.ctci.chapter1;

public class Permutation {

    public static boolean isPermutation(String string1, String string2) {

        if (string1.length() != string2.length()) {
            return false;
        }

        return sort(string1).equals(sort(string2));
    }

    private static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
}