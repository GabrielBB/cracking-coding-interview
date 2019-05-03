package com.github.gabrielbb.practicing.structures.impl;

import java.util.EmptyStackException;

import com.github.gabrielbb.practicing.structures.Stack;

public class StackImpl<T> implements Stack<T> {

    private final Object[] data;
    private int currentIndex = -1;

    public StackImpl(int maxSize) {
        data = new Object[maxSize];
    }

    public boolean push(T item) {
        if (isFull()) {
            return false;
        }

        data[++currentIndex] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) data[currentIndex];
    }

    public T pop() {
        T item = peek();
        currentIndex--;
        return item;
    }

    public boolean isEmpty() {
        return currentIndex < 0;
    }

    public boolean isFull() {
        return currentIndex == (data.length - 1);
    }

}