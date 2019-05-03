package com.github.gabrielbb.ctci.chapter2;

import com.github.gabrielbb.practicing.structures.LinkedList;
import com.github.gabrielbb.practicing.structures.LinkedList.Node;

public class SumLists {

    public static LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        return new LinkedList<>(sum(list1.node, list2.node, 0));
    }

    private static Node<Integer> sum(Node<Integer> node1, Node<Integer> node2, int reminder) {

        if (node1 == null && node2 == null && reminder == 0) {
            return null;
        }

        int sum = getData(node1) + getData(node2) + reminder;
        reminder = sum > 9 ? 1 : 0;
        sum = sum > 9 ? sum - 10 : sum;

        Node<Integer> newNode = new Node<>(sum);

        newNode.next = sum(getNextNode(node1), getNextNode(node2), reminder);

        return newNode;
    }

    private static int getData(Node<Integer> node) {
        return node == null ? 0 : node.data;
    }

    private static Node<Integer> getNextNode(Node<Integer> node) {
        return node != null ? node.next : null;
    }
}