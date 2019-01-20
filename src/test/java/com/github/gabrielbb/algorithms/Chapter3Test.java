package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;

import com.github.gabrielbb.algorithms.assignments.chapter3.StackMin;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter3Test {

    @Test
    public void testStackMin() {
        StackMin stackMin = new StackMin(10);

        stackMin.push(10);
        stackMin.push(0);
        stackMin.push(-10);
        stackMin.push(25);
        stackMin.push(0);
        stackMin.push(1);

        assertEquals(Integer.valueOf(-10), stackMin.min());
        stackMin.pop();
        stackMin.pop();
        stackMin.pop();
        stackMin.pop();
        assertEquals(Integer.valueOf(0), stackMin.min());
        stackMin.pop();
        assertEquals(Integer.valueOf(10), stackMin.min());
    }
}
