package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.LinkedList;
import com.github.gabrielbb.structures.LinkedList.Node;

public class LoopDetection {

    public static Node<Integer> getLoopNode(LinkedList<Integer> list) {

        Node<Integer> slowNode = list.node;
        Node<Integer> fastNode = list.node;

        do {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        } while (slowNode != fastNode);

        slowNode = list.node;

        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        return slowNode;
    }
}