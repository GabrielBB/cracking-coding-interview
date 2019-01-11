package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter1.IsUnique;
import com.github.gabrielbb.algorithms.assignments.chapter1.OneAway;
import com.github.gabrielbb.algorithms.assignments.chapter1.PalindromePermutation;
import com.github.gabrielbb.algorithms.assignments.chapter1.Permutation;
import com.github.gabrielbb.algorithms.assignments.chapter1.StringCompression;

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

    @Test
    public void testPalindromePermutation() {
        assertTrue(PalindromePermutation.isPalondrimePermutation("Tact Coa"));
        assertFalse(PalindromePermutation.isPalondrimePermutation("Tact Co"));
        assertTrue(PalindromePermutation.isPalondrimePermutation("Papa"));
        assertFalse(PalindromePermutation.isPalondrimePermutation(""));
        assertFalse(PalindromePermutation.isPalondrimePermutation("z"));
    }

    @Test
    public void testOneAway() {
        assertFalse(OneAway.isOneAway("pale", "bake")); // Edit 2 chars
        assertTrue(OneAway.isOneAway("pale", "pake")); // Edit 1 char

        assertTrue(OneAway.isOneAway("pale", "_pale")); // // Added 1 char
        assertFalse(OneAway.isOneAway("pale", "_paXle")); // // Added 2 chars
        assertTrue(OneAway.isOneAway("pale", "paleX")); // // Added 1 chars at the end

        assertTrue(OneAway.isOneAway("pale", "ple")); // // Added 1 chars at the end
        assertFalse(OneAway.isOneAway("pale", "le")); // // Added 2 chars at the end
    }

    @Test
    public void testStringCompression() {
        assertEquals("a3c3", StringCompression.compress("aaaccc"));
        assertEquals("a", StringCompression.compress("a"));
        assertEquals("aa", StringCompression.compress("aa"));
        assertEquals("f1x2h4", StringCompression.compress("fxxhhhh"));
    }
}
