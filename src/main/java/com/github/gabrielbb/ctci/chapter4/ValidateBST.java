package com.github.gabrielbb.ctci.chapter4;

import com.github.gabrielbb.ctci.chapter4.models.BinaryTree;
import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class ValidateBST {

    public static boolean isBST(BinaryTree<Integer> tree) {
        return isBSTNode(tree.root, null, null);
    }

    private static boolean isBSTNode(BinaryTreeNode<Integer> node, Integer min, Integer max) {

        if (node == null)
            return true;

        if ((max != null && node.data > max) || (min != null && node.data <= min))
            return false;

        return isBSTNode(node.left, min, node.data) && isBSTNode(node.right, node.data, max);
    }
}