package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class SucessorWihNoParentPointer {

    private static BinaryTree.Node<Integer> lastSucessor;

    public static BinaryTree.Node<Integer> getSucessor(BinaryTree<Integer> tree, BinaryTree.Node<Integer> targetNode) {
        getSucessor(tree.root, targetNode);
        return lastSucessor;
    }

    public static void getSucessor(BinaryTree.Node<Integer> current, BinaryTree.Node<Integer> target) {

        if (current == null)
            return;
        else if (current.data > target.data && (lastSucessor == null || current.data < lastSucessor.data))
            lastSucessor = current;

        getSucessor(current.data > target.data ? current.left : current.right, target);
    }
}