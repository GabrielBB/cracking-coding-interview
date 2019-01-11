package com.github.gabrielbb.algorithms.assignments.chapter1;

public class StringCompression {

    public static String compress(String text) {

        if (text == null || text.trim().isEmpty() || text.length() < 3) {
            return text;
        }

        final StringBuilder compressed = new StringBuilder();
        int onHoldCount = 1;
        char charOnHold = text.charAt(0);

        for (int i = 1; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            boolean ending = i == text.length() - 1;
            
            if (currentChar != charOnHold || ending) {
                compressed.append(charOnHold);
                compressed.append(ending ? onHoldCount + 1 : onHoldCount);
                onHoldCount = 1;
            } else {
                onHoldCount++;
            }

            charOnHold = currentChar;
        }

        return compressed.length() > text.length() ? text : compressed.toString();
    }
}