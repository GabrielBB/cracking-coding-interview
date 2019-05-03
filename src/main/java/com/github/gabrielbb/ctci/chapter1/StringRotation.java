package com.github.gabrielbb.ctci.chapter1;

public class StringRotation {

    public static boolean isRotation(String original, String second) {
        return original.length() == second.length() && (original + original).contains(second);
    }
}