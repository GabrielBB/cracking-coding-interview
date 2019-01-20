package com.github.gabrielbb.algorithms.assignments.chapter3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import com.github.gabrielbb.structures.Stack;
import com.github.gabrielbb.structures.impl.StackImpl;

public class SetOfStacks<T> implements Stack<T> {

    private List<Stack<T>> stacks;
    private int currentIndex = -1;
    private final int threshold;

    public SetOfStacks(int threshold) {
        stacks = new ArrayList<>();
        this.threshold = threshold;
    }

    @Override
    public boolean push(T item) {

        if (currentIndex == -1 || stacks.get(currentIndex).isFull()) {
            stacks.add(new StackImpl<>(threshold));
            currentIndex++;
        }

        return stacks.get(currentIndex).push(item);
    }

    private void checkStacks(int index) {
        if (currentIndex >= 0 && stacks.get(index).isEmpty()) {
            stacks.remove(index);
            currentIndex--;

            /*if (index == currentIndex) {
                checkStacks(currentIndex);
            } else {
                throw new EmptyStackException();
            }*/
        }

        /*if (isEmpty()) {
            throw new EmptyStackException();
        }*/
    }

    @Override
    public T peek() {

        try {
            return stacks.get(currentIndex).peek();
        } finally {
            checkStacks(currentIndex);
        }

    }

    @Override
    public T pop() {
        try {
            return stacks.get(currentIndex).pop();
        } finally {
            checkStacks(currentIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return currentIndex < 0;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }

    public T popAt(int index) {
        try {
            return stacks.get(index).pop();
        } finally {
            checkStacks(index);
        }
    }
}