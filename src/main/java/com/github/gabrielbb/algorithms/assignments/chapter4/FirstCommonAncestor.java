package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class FirstCommonAncestor {

    public static BinaryTree.Node getFirstCommonAncestor(BinaryTree.Node node1, BinaryTree.Node node2) {

        BinaryTree.Node current = node1.parent;

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
