package com.github.gabrielbb.ctci.hard;

import java.util.Random;

public class Shuffle {

    public static void shuffle(int[] cards) {

        var random = new Random();

        for (int i = cards.length - 1; i >= 1; i--) {

            int chosen = random.nextInt(i);

            int temp = cards[i];

            cards[i] = cards[chosen];
            cards[chosen] = temp;
        }
    }
}