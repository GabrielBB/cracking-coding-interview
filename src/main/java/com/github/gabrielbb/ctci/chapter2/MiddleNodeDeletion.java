package com.github.gabrielbb.ctci.chapter2;

import com.github.gabrielbb.practicing.structures.LinkedList.Node;

public class MiddleNodeDeletion {

    public static void deleteNode(Node<Integer> node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}