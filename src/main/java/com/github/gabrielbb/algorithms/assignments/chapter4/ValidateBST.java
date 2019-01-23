package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class ValidateBST {

    public static boolean isBST(BinaryTree<Integer> tree) {
        return isBSTNode(tree.root);
    }

    private static boolean isBSTNode(BinaryTree.Node<Integer> node) {

        if (node == null)
            return true;

        if ((node.left != null && node.left.data > node.data) || (node.right != null && node.right.data <= node.data))
            return false;

        return isBSTNode(node.left) && isBSTNode(node.right);
    }
}