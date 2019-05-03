package com.github.gabrielbb.ctci;

import static org.junit.Assert.assertEquals;

import com.github.gabrielbb.ctci.chapter5.BinaryToString;
import com.github.gabrielbb.ctci.chapter5.FlipBitToWin;
import com.github.gabrielbb.ctci.chapter5.Insertion;
import com.github.gabrielbb.ctci.chapter5.NextNumber;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter5Test {

    @Test
    public void testInsertion() {
        assertEquals(0b10001001100, Insertion.insert(0b10000000000, 0b10011, 2, 6));
    }

    @Test
    public void testIntegerToString() {
        assertEquals(Integer.toBinaryString(5), BinaryToString.convert(5));
        assertEquals(Integer.toBinaryString(1), BinaryToString.convert(1));
        assertEquals(Integer.toBinaryString(0), BinaryToString.convert(0));
        assertEquals(Integer.toBinaryString(26841), BinaryToString.convert(26841));
        assertEquals(Integer.toBinaryString(5832), BinaryToString.convert(5832));
    }

    @Test
    public void testDoubleToString() {
        assertEquals("0.101", BinaryToString.convert(0.625));
    }

    @Test
    public void flipBitToWin() {
        assertEquals(1, FlipBitToWin.findLongest1Sequence(5));
        assertEquals(8, FlipBitToWin.findLongest1Sequence(1775));
    }

    @Test
    public void testNextNumber() {
        assertEquals(12, NextNumber.findLargestNextNumber(10));
        assertEquals(20, NextNumber.findLargestNextNumber(12));
        assertEquals(0, NextNumber.findLargestNextNumber(0));
        assertEquals(26, NextNumber.findLargestNextNumber(22));
    }
}
