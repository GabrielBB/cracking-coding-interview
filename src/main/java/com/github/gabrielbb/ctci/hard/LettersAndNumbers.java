package com.github.gabrielbb.ctci.hard;

public class LettersAndNumbers {

    public static int[] getLongestSubArray(char[] array) {

        var maxRange = new int[2];
        var indexByDiference = new Integer[array.length + 1];

        int numbers = 0;
        int letters = 0;
        Integer lastDifferenceIndex;

        indexByDiference[0] = 0;
        for (int i = 0; i < array.length; i++) {

            if (Character.isDigit(array[i])) {
                numbers++;
            } else if (Character.isLetter(array[i])) {
                letters++;
            } else {
                continue;
            }

            int difference = Math.abs(letters - numbers);

            if ((lastDifferenceIndex = indexByDiference[difference]) != null) {
                if (i - lastDifferenceIndex > maxRange[1] - maxRange[0]) {
                    maxRange[0] = lastDifferenceIndex;
                    maxRange[1] = i;
                }
            } else {
                indexByDiference[difference] = i;
            }
        }

        if (!(maxRange[0] == 0 && maxRange[1] == 0)) {
            maxRange[0]++;
        }

        return maxRange;
    }
}