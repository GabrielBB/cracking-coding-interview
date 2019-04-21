package com.github.gabrielbb.algorithms.assignments.chapter10;

public class SortedSearchNoSize {

    public static class Listy {

        private int[] array;

        public Listy(int[] array) {
            this.array = array;
        }

        public int elementAt(int x) {
            if (x < 0 || x >= array.length)
                return -1;

            return array[x];
        }
    }

    private static final int SEARCH_RANGE = 100;

    public static int search(Listy listy, int num) {

        int rightIndex = SEARCH_RANGE;

        while(listy.elementAt(rightIndex) < num && listy.elementAt(rightIndex) != -1) {
            rightIndex += SEARCH_RANGE;
        }

        return binarySearch(listy, num, rightIndex - SEARCH_RANGE, rightIndex);
    }

    private static int binarySearch(Listy listy, int num, int left, int right) {

        if(left > right)
            return -1;

        int mid = (left + right) / 2;
        int midValue = listy.elementAt(mid);

        if(midValue > num || midValue == -1) {
            return binarySearch(listy, num, left, mid -1);
        } else if (midValue < num) {
            return binarySearch(listy, num, mid + 1, right);
        } else {
            return mid;
        }
    }
}