package com.github.gabrielbb.algorithms.assignments.chapter4.models;

public class BinarySearchTree<T> {

    public Node<T> root;

    public BinarySearchTree(Node<T> root) {
        this.root = root;
    }

    public static class Node<T> {

        public Node<T> left;
        public Node<T> right;
        public T data;

        public Node() {

        }

        public Node(T data) {
            this.data = data;
        }
    }
}
