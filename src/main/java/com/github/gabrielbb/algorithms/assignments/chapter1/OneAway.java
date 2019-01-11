package com.github.gabrielbb.algorithms.assignments.chapter1;

public class OneAway {

    public static boolean isOneAway(String text1, String text2) {

        int edits = 0;
        int c2IndexPlus = 0;

        for (int i = 0; i < text1.length(); i++) {
            char c1 = text1.charAt(i);

            int c2Index = i + c2IndexPlus;
            char c2 = text2.charAt(c2Index);

            if (c2 != c1) {

                if (text2.length() < text1.length() && text1.charAt(i + 1) == c2) {
                    // c1 was deleted
                    c2IndexPlus--;
                } else if (text2.length() > text1.length() && text2.charAt(c2Index + 1) == c1) {
                    // c2 was added
                    c2IndexPlus++;
                } else {
                    // c2 was replaced
                }

                if (++edits > 1) {
                    return false;
                }
            }
        }

        // If text2 has added chars at its end, the loop can't see them, so this condition checks if more than 1 char was added
        return (text2.length() - text1.length()) <= 1;
    }
}