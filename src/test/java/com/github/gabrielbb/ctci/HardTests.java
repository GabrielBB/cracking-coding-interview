package com.github.gabrielbb.ctci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.github.gabrielbb.ctci.hard.AddWithoutPlus;
import com.github.gabrielbb.ctci.hard.RandomSet;
import com.github.gabrielbb.ctci.hard.Shuffle;

import org.junit.Test;

public class HardTests {

    @Test
    public void testAddWithoutPlus() {
        assertEquals(6, AddWithoutPlus.add(2, 4));
        assertEquals(105, AddWithoutPlus.add(5, 100));
        assertEquals(0, AddWithoutPlus.add(0, 0));
        assertEquals(-20, AddWithoutPlus.add(-10, -10));
        assertEquals(1, AddWithoutPlus.add(-1000, 1001));
    }

    @Test
    public void testShuffle() {
        int[] cards = new int[52];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = i;
        }

        Shuffle.shuffle(cards);

        Set<Integer> set = new HashSet<>();
        Arrays.stream(cards).forEach(set::add);

        assertEquals(cards.length, set.size());
    }

    @Test
    public void testRandomSet() {
        testRandomSet(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 9);
        testRandomSet(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 1);
        testRandomSet(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 4);
    }

    private void testRandomSet(int[] array, int subsetLength) {
        int[] subset = RandomSet.generateSubSet(array, subsetLength);

        assertEquals(subsetLength, subset.length);

        Arrays.stream(subset).forEach(n -> assertNotEquals(0, n));
    }
}