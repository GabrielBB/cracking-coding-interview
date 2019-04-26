package com.github.gabrielbb.algorithms.assignments.chapter4.models;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import com.github.gabrielbb.structures.BinaryTreeNode;

public class BinaryTree<T> {

    public BinaryTreeNode<T> root;
    private int count;
    private Random random = new Random();

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRandomNode() {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        int curr = 0;
        int index = random.nextInt(count);

        while (true) {
            BinaryTreeNode<T> currentNode = queue.remove();

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

    public void insert(BinaryTreeNode<T> node) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            BinaryTreeNode<T> currentNode = queue.remove();

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

    
}
