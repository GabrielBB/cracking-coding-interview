package com.github.gabrielbb.algorithms.assignments.chapter4.models;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public Node[] nodes;

    public static class Node<T> {

        public T value;
        public List<Node<T>> children = new ArrayList<>();
        public boolean visited;

        public Node() {

        }

        public Node(T name) {
            this.value = name;
        }
    }
}