package com.github.gabrielbb.ctci.chapter1;

public class IsUnique {

    public static boolean isUnique(String text) {
        Object[] chars = new Object[128];
        
        for(char c : text.toCharArray()) {
            if (chars[c] != null) {
                return false;
            }

            chars[c] = new Object();
        }

        return true;
    }
}