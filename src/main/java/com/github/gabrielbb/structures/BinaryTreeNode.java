package com.github.gabrielbb.structures;

public class BinaryTreeNode<T> {

    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode<T> parent;
    public T data;
    public boolean visited;
    public int rank;
    public int count;

    public BinaryTreeNode() {

    }

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public int getRealRank() {
        return rank + count;
    }
}