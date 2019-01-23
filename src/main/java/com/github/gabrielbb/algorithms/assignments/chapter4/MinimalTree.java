package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinarySearchTree;
import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinarySearchTree.Node;

public class MinimalTree {

    public static BinarySearchTree<Integer> createBinarySearchTree(int[] array) {
        Node<Integer> root = renderChildren(array, 0, array.length - 1);
        return new BinarySearchTree<>(root);
    }

    private static Node<Integer> renderChildren(int[] array, int start, int end) {

        if (end < start) {
            return null;
        }

        int middle = (start + end) / 2;
        var node = new Node<>(array[middle]);
        node.left = renderChildren(array, start, middle - 1);
        node.right = renderChildren(array, middle + 1, end);

        return node;
    }
}