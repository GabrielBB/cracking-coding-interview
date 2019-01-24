package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class ValidateBST {

    public static boolean isBST(BinaryTree<Integer> tree) {
        return isBSTNode(tree.root, null, null);
    }

    private static boolean isBSTNode(BinaryTree.Node<Integer> node, Integer min, Integer max) {

        if (node == null)
            return true;

        if ((max != null && node.data > max) || (min != null && node.data <= min))
            return false;

        return isBSTNode(node.left, min, node.data) && isBSTNode(node.right, node.data, max);
    }
}