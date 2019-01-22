package com.github.gabrielbb.algorithms.assignments.chapter4;

public class Node {

    public String name;
    public Node[] children = new Node[0];
    public boolean visited;

    public Node() {

    }

    public Node(String name) {
        this.name = name;
    }
}