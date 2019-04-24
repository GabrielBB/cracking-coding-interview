package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;

import com.github.gabrielbb.algorithms.assignments.chapter5.Insertion;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter5Test {

    @Test
    public void testInsertion() {
        assertEquals(0b10001001100, Insertion.insert(0b10000000000, 0b10011, 2, 6));
    }

}
