package com.github.gabrielbb.practicing.structures;

public class BinaryTreeNode<T> {

    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;
    public T data;
    public boolean visited;
    public int rank;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}