package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter2.RemoveDups;
import com.github.gabrielbb.structures.impl.LinkedListImpl;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter2Test {

    @Test
    public void testRemoveDupsWhileSorting() {

        var original = new LinkedListImpl<>(-100, 2, 2, 4, 4, 4, -100);

        RemoveDups.removeDupsWhileSorting(original);

        var expected = new LinkedListImpl<>(-100, 2, 4);

        assertEquals(expected, original);

        original = new LinkedListImpl<>(100, 4, 1, 4, 100, 0);

        RemoveDups.removeDupsWhileSorting(original);

        expected = new LinkedListImpl<>(0, 1, 4, 100);

        assertEquals(expected, original);
    }
}
