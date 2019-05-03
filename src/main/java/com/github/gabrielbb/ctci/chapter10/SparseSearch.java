package com.github.gabrielbb.ctci.chapter10;

public class SparseSearch {

    public static int findString(String string, String[] array) {
        return binarySearch(array, string, 0, array.length - 1);
    }

    private static int getNonEmptyMid(String[] array, int left, int right) {
        int mid = (left + right) / 2;

        while (array[mid].isEmpty() && mid > left) {
            mid--;
        }

        while (array[mid].isEmpty() && mid < right) {
            mid++;
        }

        return mid;
    }

    private static int binarySearch(String[] array, String string, int left, int right) {

        if (left > right)
            return -1;

        int mid = getNonEmptyMid(array, left, right);
        String midValue = array[mid];

        if (midValue.isEmpty() && !string.isEmpty()) {
            return -1;
        } else if (midValue.compareTo(string) > 0) {
            return binarySearch(array, string, left, mid - 1);
        } else if (midValue.compareTo(string) < 0) {
            return binarySearch(array, string, mid + 1, right);
        } else {
            return mid;
        }
    }
}