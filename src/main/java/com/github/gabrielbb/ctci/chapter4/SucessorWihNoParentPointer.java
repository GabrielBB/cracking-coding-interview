package com.github.gabrielbb.ctci.chapter4;

import com.github.gabrielbb.ctci.chapter4.models.BinaryTree;
import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class SucessorWihNoParentPointer {

    private static BinaryTreeNode<Integer> lastSucessor;

    public static BinaryTreeNode<Integer> getSucessor(BinaryTree<Integer> tree, BinaryTreeNode<Integer> targetNode) {
        getSucessor(tree.root, targetNode);
        return lastSucessor;
    }

    public static void getSucessor(BinaryTreeNode<Integer> current, BinaryTreeNode<Integer> target) {

        if (current == null)
            return;
        else if (current.data > target.data && (lastSucessor == null || current.data < lastSucessor.data))
            lastSucessor = current;

        getSucessor(current.data > target.data ? current.left : current.right, target);
    }
}