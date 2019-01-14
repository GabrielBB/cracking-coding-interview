package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;

import com.github.gabrielbb.algorithms.assignments.chapter2.KthToLast;
import com.github.gabrielbb.algorithms.assignments.chapter2.MiddleNodeDeletion;
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

    @Test
    public void testRemoveDups() {

        var original = new LinkedList<>(-100, 2, 2, -100);

        RemoveDups.removeDups(original);

        var expected = new LinkedList<>(-100, 2);

        assertEquals(expected, original);

        original = new LinkedList<>(100, 4, 1, 4, 100, 0);

        RemoveDups.removeDups(original);

        expected = new LinkedList<>(100, 4, 1, 0);

        assertEquals(expected, original);
    }

    @Test
    public void testKthToLast() {

        var original = new LinkedList<>(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertEquals(6, KthToLast.findKthToLast(original, 3));
        assertEquals(8, KthToLast.findKthToLast(original, 1));

    }

    @Test
    public void testMiddleNodeDeletion() {

        var list = new LinkedList<>(1, 2, 3, 4, 5, 6);

        MiddleNodeDeletion.deleteNode(list.node.next.next);

        assertEquals(new LinkedList<>(1, 2, 4, 5, 6), list);

        list = new LinkedList<>(1, 2, 3, 4, 5);

        MiddleNodeDeletion.deleteNode(list.node.next.next.next);

        assertEquals(new LinkedList<>(1, 2, 3, 5), list);
    }
}
