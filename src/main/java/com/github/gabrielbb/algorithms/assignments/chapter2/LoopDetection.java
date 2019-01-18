package com.github.gabrielbb.algorithms.assignments.chapter2;

import java.util.HashMap;

import com.github.gabrielbb.structures.LinkedList;
import com.github.gabrielbb.structures.LinkedList.Node;

public class LoopDetection {

    public static Node<Integer> getLoopNode(LinkedList<Integer> list) {

        Node<Integer> slowNode = list.node;
        Node<Integer> fastNode = slowNode;

        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        return slowNode;
    }
}