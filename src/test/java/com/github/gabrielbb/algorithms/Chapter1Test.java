package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter1.IsUnique;
import com.github.gabrielbb.algorithms.assignments.chapter1.Permutation;

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

    @Test
    public void testPermutation() {
        assertTrue(Permutation.isPermutation("Casa", "asaC"));
        assertTrue(Permutation.isPermutation("KELOKE", "KKOLEE"));
        assertFalse(Permutation.isPermutation("messaka[p[askdge", "sadasdsadsdasd"));
        assertFalse(Permutation.isPermutation("", "  "));
    }
}
