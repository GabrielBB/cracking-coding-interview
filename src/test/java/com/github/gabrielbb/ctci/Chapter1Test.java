package com.github.gabrielbb.ctci;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.ctci.chapter1.IsUnique;
import com.github.gabrielbb.ctci.chapter1.MatrixRotation;
import com.github.gabrielbb.ctci.chapter1.OneAway;
import com.github.gabrielbb.ctci.chapter1.PalindromePermutation;
import com.github.gabrielbb.ctci.chapter1.Permutation;
import com.github.gabrielbb.ctci.chapter1.StringCompression;
import com.github.gabrielbb.ctci.chapter1.StringRotation;
import com.github.gabrielbb.ctci.chapter1.ZeroMatrix;

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

    @Test
    public void testMatrixRotation() {

        int[][] original = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int[][] expected = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };

        assertArrayEquals(expected, MatrixRotation.rotate(original));
    }

    @Test
    public void testZeroMatrix() {

        var original = new int[][] { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

        var expected = new int[][] { { 1, 0, 3 }, { 0, 0, 0 }, { 7, 0, 9 } };

        ZeroMatrix.convert(original);

        assertArrayEquals(expected, original);

        original = new int[][] { { 1, 2, 0 }, { 4, 5, 6 }, { 0, 8, 9 } };

        expected = new int[][] { { 0, 0, 0 }, { 0, 5, 0 }, { 0, 0, 0 } };

        ZeroMatrix.convert(original);

        assertArrayEquals(expected, original);
    }

    @Test
    public void testStringRotation() {
        assertTrue(StringRotation.isRotation("erbottlewat", "waterbottle"));
        assertFalse(StringRotation.isRotation("erzottlewat", "waterbottle"));
        assertTrue(StringRotation.isRotation("waterbottle", "erbottlewat"));
        assertFalse(StringRotation.isRotation("   ", "         "));
        assertTrue(StringRotation.isRotation("", ""));
    }
}
