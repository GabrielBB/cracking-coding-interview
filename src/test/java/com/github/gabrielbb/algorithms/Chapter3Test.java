package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter3.SetOfStacks;
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

    @Test
    public void testSetOfStacks() {
        SetOfStacks<Integer> stacks = new SetOfStacks<>(2);
        assertTrue(stacks.isEmpty());

        stacks.push(1);
        stacks.push(2);

        assertEquals(Integer.valueOf(2), stacks.peek());

        stacks.push(3);
        stacks.push(4);

        assertEquals(Integer.valueOf(2), stacks.popAt(0));
        assertEquals(Integer.valueOf(1), stacks.popAt(0));

        assertEquals(Integer.valueOf(4), stacks.pop());
        assertEquals(Integer.valueOf(3), stacks.pop());

        assertTrue(stacks.isEmpty());
    }
}
