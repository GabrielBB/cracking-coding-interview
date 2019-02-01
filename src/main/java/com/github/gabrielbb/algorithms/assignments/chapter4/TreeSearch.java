package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSearch {

    private enum BSTSequenceType {
        DEPTH_LEFT_RIGHT,
        DEPTH_RIGHT_LEFT,
        BREADTH_LEFT_RIGHT,
        BREADTH_RIGHT_LEFT;
    }

    private static List<Integer>[] sequences;

    private static List<Integer> getSequenceByType(BSTSequenceType type) {
        if (sequences[type.ordinal()] == null) {
            sequences[type.ordinal()] = new ArrayList<>();
        }

        return sequences[type.ordinal()];
    }

    public static List<Integer>[] generateSequences(BinaryTree<Integer> tree) {
        sequences = new List[BSTSequenceType.values().length];

        depthSearch(tree.root, BSTSequenceType.DEPTH_LEFT_RIGHT);
        depthSearch(tree.root, BSTSequenceType.DEPTH_RIGHT_LEFT);
        breadthSearch(tree.root, BSTSequenceType.BREADTH_LEFT_RIGHT);
        breadthSearch(tree.root, BSTSequenceType.BREADTH_RIGHT_LEFT);

        return sequences;
    }

    private static void depthSearch(BinaryTree.Node<Integer> node, BSTSequenceType type) {
        if (node == null)
            return;

        getSequenceByType(type).add(node.data);

        if (type == BSTSequenceType.DEPTH_LEFT_RIGHT) {
            depthSearch(node.left, type);
            depthSearch(node.right, type);
        } else if (type == BSTSequenceType.DEPTH_RIGHT_LEFT) {
            depthSearch(node.right, type);
            depthSearch(node.left, type);
        }
    }

    private static void breadthSearch(BinaryTree.Node<Integer> root, BSTSequenceType type) {
        final Queue<BinaryTree.Node<Integer>> queue = new LinkedList<>();
        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree.Node<Integer> node = queue.remove();

            if (node == null)
                continue;

            getSequenceByType(type).add(node.data);

            if (type == BSTSequenceType.BREADTH_LEFT_RIGHT) {
                queue.add(node.left);
                queue.add(node.right);
            } else if (type == BSTSequenceType.BREADTH_RIGHT_LEFT) {
                queue.add(node.right);
                queue.add(node.left);
            }
        }
    }
}
