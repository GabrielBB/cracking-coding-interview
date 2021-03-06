package com.github.gabrielbb.ctci.chapter4;

import com.github.gabrielbb.ctci.chapter4.models.BinaryTree;
import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class CheckBalanced {

    private static int maxDepth;

    public static boolean isBalanced(BinaryTree<Integer> tree) {
        if (tree == null)
            return true;

        maxDepth = 0;

        return search(tree.root, 0);
    }

    private static boolean search(BinaryTreeNode<Integer> node, int depth) {

        if (node == null) {

            if (maxDepth == 0) {
                maxDepth = depth;
                return true;
            }

            return depth >= maxDepth - 1 && depth <= maxDepth + 1;

        }

        return search(node.left, depth + 1) && search(node.right, depth + 1);
    }
}