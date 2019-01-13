package com.github.gabrielbb.structures;

import java.util.function.Predicate;

public interface LinkedList<T> {

    public static class Node<T> {

        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> add(T data);

    Node<T> delete(Predicate<T> predicate);
}