package com.github.gabrielbb.ctci.chapter4;

import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class FirstCommonAncestor {

    public static BinaryTreeNode getFirstCommonAncestor(BinaryTreeNode node1, BinaryTreeNode node2) {

        BinaryTreeNode current = node1.parent;

        while (current != null) {
            current.visited = true;
            current = current.parent;
        }

        current = node2.parent;
        while (current != null) {
            if (current.visited)
                return current;
            current = current.parent;
        }
        return null;
    }
}
