package com.github.gabrielbb.ctci.chapter3;

import com.github.gabrielbb.practicing.structures.Stack;
import com.github.gabrielbb.practicing.structures.impl.StackImpl;

public class StackMin extends StackImpl<Integer> {

    private final Stack<Integer> minStack;

    public StackMin(int maxSize) {
        super(maxSize);
        minStack = new StackImpl<>(maxSize);
    }

    public Integer min() {
        return minStack.peek();
    }

    @Override
    public boolean push(Integer item) {
        if (super.push(item)) {

            if (minStack.isEmpty() || item <= min()) {
                minStack.push(item);
            }

            return true;
        }

        return false;
    }

    @Override
    public Integer pop() {
        Integer popped = super.pop();

        if (minStack.peek() == popped) {
            minStack.pop();
        }

        return popped;
    }

}