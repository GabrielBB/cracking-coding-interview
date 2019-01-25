package com.github.gabrielbb.algorithms.assignments.chapter4.models;

public class BinaryTree<T> {

    public Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public static class Node<T> {

        public Node<T> left;
        public Node<T> right;
        public Node<T> parent;
        public T data;
        public boolean visited;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }
    }
}
