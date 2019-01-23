package com.github.gabrielbb.algorithms.assignments.chapter4.models;

public class Graph {

    public Node[] nodes;

    public static class Node<T> {

        public T value;
        public Node<T>[] children = new Node[0];
        public boolean visited;

        public Node() {

        }

        public Node(T name) {
            this.value = name;
        }
    }
}