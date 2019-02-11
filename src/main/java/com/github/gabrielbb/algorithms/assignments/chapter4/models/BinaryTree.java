package com.github.gabrielbb.algorithms.assignments.chapter4.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree<T> {

    public Node<T> root;
    private int count;
    private Random random = new Random();

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRandomNode() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        int curr = 0;
        int index = random.nextInt(count);

        while (true) {
            Node<T> currentNode = queue.remove();

            if (curr == index) {
                return currentNode;
            }

            if (currentNode != null) {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }

            curr++;
        }
    }

    public void insert(Node<T> node) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node<T> currentNode = queue.remove();

            if (currentNode.left == null) {
                currentNode.left = node;
                break;
            }

            if (currentNode.right == null) {
                currentNode.right = node;
                break;
            }

            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        count++;
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
