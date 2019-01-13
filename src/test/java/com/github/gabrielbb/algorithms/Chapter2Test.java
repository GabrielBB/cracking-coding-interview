package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import com.github.gabrielbb.algorithms.assignments.chapter2.RemoveDups;
import com.github.gabrielbb.structures.LinkedList;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter2Test {

    @Test
    public void testRemoveDupsWhileSorting() {

        var original = new LinkedList<>(-100, 2, 2, 4, 4, 4, -100);

        RemoveDups.removeDupsWhileSorting(original);

        var expected = new LinkedList<>(-100, 2, 4);

        assertEquals(expected, original);

        original = new LinkedList<>(100, 4, 1, 4, 100, 0);

        RemoveDups.removeDupsWhileSorting(original);

        expected = new LinkedList<>(0, 1, 4, 100);

        assertEquals(expected, original);
    }
}
