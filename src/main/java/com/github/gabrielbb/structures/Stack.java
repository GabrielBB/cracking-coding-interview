package com.github.gabrielbb.structures;

public interface Stack<T> {

    boolean push(T item);
    T peek();
    T pop();
    boolean isEmpty();
    boolean isFull();
}