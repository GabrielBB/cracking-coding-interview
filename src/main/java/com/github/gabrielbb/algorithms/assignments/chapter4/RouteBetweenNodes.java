package com.github.gabrielbb.algorithms.assignments.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    public static boolean findRoute(Node root, Node goal) {

        Queue<Node> queue = new LinkedList<>();

        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.remove();

            if (node == goal)
                return true;

            for (Node child : node.children)
                if (!child.visited) {
                    child.visited = true;
                    queue.add(child);
                }
        }

        return false;
    }
}