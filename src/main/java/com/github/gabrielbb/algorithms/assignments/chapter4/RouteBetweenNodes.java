package com.github.gabrielbb.algorithms.assignments.chapter4;

import java.util.LinkedList;
import java.util.Queue;
import com.github.gabrielbb.algorithms.assignments.chapter4.models.Graph.Node;

public class RouteBetweenNodes {

    public static boolean findRoute(Node<Integer> root, Node<Integer> goal) {

        Queue<Node<Integer>> queue = new LinkedList<>();

        root.visited = true;
        queue.add(root);

        while (!queue.isEmpty()) {

            Node<Integer> node = queue.remove();

            if (node == goal)
                return true;

            for (Node<Integer> child : node.children)
                if (!child.visited) {
                    child.visited = true;
                    queue.add(child);
                }
        }

        return false;
    }
}