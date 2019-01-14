package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.LinkedList.Node;

public class MiddleNodeDeletion {

    public static void deleteNode(Node<Integer> node) {

        Node<Integer> currentNode = node;

        while (currentNode != null) {

            currentNode.data = currentNode.next.data;

            if(currentNode.next.next == null) {
                currentNode.next = null;
            }

            currentNode = currentNode.next;
        }
    }
}