package com.github.gabrielbb.structures;

public class BinaryTreeNode<T> {

    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;
    public T data;
    public boolean visited;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}