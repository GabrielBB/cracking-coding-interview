package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter2.*;
import com.github.gabrielbb.structures.LinkedList;
import com.github.gabrielbb.structures.LinkedList.Node;

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

    @Test
    public void testSumLists() {

        LinkedList<Integer> result = SumLists.sumLists(new LinkedList<>(7, 1, 6), new LinkedList<>(5, 9, 2));

        assertEquals(new LinkedList<>(2, 1, 9), result);

        result = SumLists.sumLists(new LinkedList<>(7, 1, 6, 2), new LinkedList<>(5, 9, 2));

        assertEquals(new LinkedList<>(2, 1, 9, 2), result);

        result = SumLists.sumLists(new LinkedList<>(7, 0, 0, 9), new LinkedList<>(5, 0, 9));

        assertEquals(new LinkedList<>(2, 1, 9, 9), result);
    }

    @Test
    public void testPalindrome() {

        assertTrue(Palindrome.isPalindrome(new LinkedList<>("c", "a", "b", "z", "b", "a", "c")));
        assertTrue(Palindrome.isPalindrome(new LinkedList<>("c", "a", "b", "b", "a", "c")));
        assertTrue(Palindrome.isPalindrome(new LinkedList<>("c")));
        assertTrue(Palindrome.isPalindrome(new LinkedList<>()));
        assertFalse(Palindrome.isPalindrome(new LinkedList<>("c", "a", "z", "z", "b", "a", "c")));
    }

    @Test
    public void testLoopDetection() {
        var node1 = new Node<>(1);
        var node2 = new Node<>(2);
        var node3 = new Node<>(3);
        var node4 = new Node<>(4);
        var node5 = new Node<>(5);
        var node6 = new Node<>(6);
        var node7 = new Node<>(7);
        var node8 = new Node<>(8);
        var node9 = new Node<>(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node3;

        assertEquals(node3, LoopDetection.getLoopNode(new LinkedList<>(node1)));
    }
}
