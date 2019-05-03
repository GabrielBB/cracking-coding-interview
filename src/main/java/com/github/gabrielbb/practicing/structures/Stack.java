package com.github.gabrielbb.practicing.structures;

public interface Stack<T> {

    boolean push(T item);
    T peek();
    T pop();
    boolean isEmpty();
    boolean isFull();
}