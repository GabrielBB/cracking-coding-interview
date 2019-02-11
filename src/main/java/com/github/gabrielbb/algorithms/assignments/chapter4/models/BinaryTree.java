package com.github.gabrielbb.algorithms.assignments.chapter4.models;

public class BinaryTree<T> {

    public Node<T> root;
    private int depth = 1;
    private int nodesInDepth = 0;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public void insert(Node<T> node) {
        if (nodesInDepth == (depth * 2)) {
            depth++;
            nodesInDepth = 0;
        }

        insert(node, 1);
    }

    private boolean insert(Node<T> node, int depth) {

        if (depth == this.depth) {
            
        }

        return false;
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
