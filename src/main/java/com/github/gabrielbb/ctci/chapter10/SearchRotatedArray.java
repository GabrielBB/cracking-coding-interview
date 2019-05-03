package com.github.gabrielbb.ctci.chapter10;

public class SearchRotatedArray {

    public int find(int[] array, int num) {
        return binarySearchRecursive(array, num, 0, array.length - 1);
    }

    private int binarySearchRecursive(int[] a, int x, int left, int right) {
        if (left > right)
            return -1; // Error

        int mid = (left + right) / 2;

        if (x == a[mid]) {
            return mid;
        }

        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return binarySearchRecursive(a, x, left, mid - 1);
            }

            return binarySearchRecursive(a, x, mid + 1, right);
        } else if (a[mid] < a[right]) { // Right is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return binarySearchRecursive(a, x, mid + 1, right);
            }
            return binarySearchRecursive(a, x, left, mid - 1);
        } else if (a[mid] == a[left]) {
            if (a[mid] != a[right]) {
                return binarySearchRecursive(a, x, mid + 1, right);
            } else { 
                int result = binarySearchRecursive(a, left, mid - 1, x); // Search left
                if (result == -1) {
                    return binarySearchRecursive(a, mid + 1, right, x); // Search right
                } else {
                    return result;
                }
            }
        }

        return -1;
    }

}