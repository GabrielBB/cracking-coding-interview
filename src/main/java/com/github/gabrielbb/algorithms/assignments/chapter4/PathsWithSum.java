package com.github.gabrielbb.algorithms.assignments.chapter4;

import java.util.LinkedList;
import java.util.Queue;

import com.github.gabrielbb.structures.BinaryTreeNode;

public class PathsWithSum {

    public static int getPathCount(BinaryTreeNode<Integer> root, int value) {

        int paths = 0;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        while (!queue.isEmpty()) {

            var node = queue.remove();

            if (node != null && !node.visited) {
                if (isValueOnPath(node, 0, value)) {
                    paths++;
                }

                node.visited = true;
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return paths;
    }

    private static boolean isValueOnPath(BinaryTreeNode<Integer> node, int sum, int value) {

        if (node != null) {

            sum += node.data;

            if (sum == value) {
                return true;
            }

            return isValueOnPath(node.left, sum, value) || isValueOnPath(node.right, sum, value);
        }

        return false;
    }
}