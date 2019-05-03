package com.github.gabrielbb.ctci;

import static org.junit.Assert.assertEquals;

import com.github.gabrielbb.ctci.hard.AddWithoutPlus;

import org.junit.Test;

public class HardTests {

    @Test
    public void testAddWithoutPlus() {
        assertEquals(6, AddWithoutPlus.add(2, 4));
        assertEquals(105, AddWithoutPlus.add(5, 100));
        assertEquals(0, AddWithoutPlus.add(0, 0));
        assertEquals(-20, AddWithoutPlus.add(-10, -10));
        assertEquals(1, AddWithoutPlus.add(-1000, 1001));
    }
}