package com.github.gabrielbb.structures.impl;

import java.util.EmptyStackException;

import com.github.gabrielbb.structures.Stack;
import com.github.gabrielbb.structures.impl.StackImpl;

import org.junit.Assert;
import org.junit.Test;

public class StackTests {

    @Test(expected = EmptyStackException.class)
    public void testStack() {
        Stack<Integer> theStack = new StackImpl<Integer>(10); // make new stack
        theStack.push(20); // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        Assert.assertEquals(80, theStack.pop().intValue());
        Assert.assertEquals(60, theStack.pop().intValue());
        Assert.assertEquals(40, theStack.pop().intValue());
        Assert.assertEquals(20, theStack.pop().intValue());
        theStack.pop();
    }
}