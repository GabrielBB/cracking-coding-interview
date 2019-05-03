package com.github.gabrielbb.ctci.chapter1;

public class StringCompression {

    public static String compress(String text) {

        if (text == null || text.trim().isEmpty() || text.length() < 3) {
            return text;
        }

        final StringBuilder compressed = new StringBuilder();
        int onHoldCount = 0;

        for (int i = 0; i < text.length(); i++) {

            char currentChar = text.charAt(i);
            onHoldCount++;
            
            if ((i == text.length() - 1) || currentChar != text.charAt(i + 1)) {
                compressed.append(currentChar);
                compressed.append(onHoldCount);
                onHoldCount = 0;
            }
        }

        return compressed.length() > text.length() ? text : compressed.toString();
    }
}