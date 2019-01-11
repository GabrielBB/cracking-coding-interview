package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter1.IsUnique;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter1Test {

    @Test
    public void testIsUnique() {
        assertTrue(IsUnique.isUnique("Carote"));
        assertFalse(IsUnique.isUnique("Casa"));
    }
}
