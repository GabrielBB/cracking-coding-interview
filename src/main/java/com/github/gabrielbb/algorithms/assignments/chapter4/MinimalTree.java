package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;
import com.github.gabrielbb.structures.BinaryTreeNode;

public class MinimalTree {

    public static BinaryTree<Integer> createBinarySearchTree(int[] array) {
        BinaryTreeNode<Integer> root = renderChildren(array, 0, array.length - 1);
        return new BinaryTree<>(root);
    }

    private static BinaryTreeNode<Integer> renderChildren(int[] array, int start, int end) {

        if (end < start) {
            return null;
        }

        int middle = (start + end) / 2;
        var node = new BinaryTreeNode<>(array[middle]);
        node.left = renderChildren(array, start, middle - 1);
        node.right = renderChildren(array, middle + 1, end);

        return node;
    }
}