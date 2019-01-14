package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.LinkedList.Node;

public class MiddleNodeDeletion {

    public static void deleteNode(Node<Integer> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}