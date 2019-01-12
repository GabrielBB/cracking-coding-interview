package com.github.gabrielbb.algorithms.assignments.chapter1;

public class StringRotation {

    public static boolean isRotation(String original, String second) {

        if (original == null || second == null || original.length() != second.length()) {
            return false;
        }

        if(original.isEmpty() && second.isEmpty()) {
            return true;
        }

        char[] oChars = original.toCharArray();
        char[] sChars = second.toCharArray();

        int oIndex = 0;
        int sIndex = second.indexOf(oChars[oIndex]);

        if (sIndex < 0) {
            return false;
        }

        while (sIndex < sChars.length) {
            if (oChars[oIndex] != sChars[sIndex]) {
                return false;
            }

            sIndex++;
            oIndex++;
        }

        return oIndex == original.length() - 1 // Reached the end and everything was the same
                || original.substring(oIndex).equals(second.substring(0, original.length() - oIndex));
    }
}