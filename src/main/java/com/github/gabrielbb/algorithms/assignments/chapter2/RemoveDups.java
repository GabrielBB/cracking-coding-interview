package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.impl.LinkedListImpl;

public class RemoveDups {

    public static void removeDupsWhileSorting(LinkedListImpl<Integer> list) {

        var swapped = new boolean[1];

        do {
            swapped[0] = false;

            LinkedListImpl.Node<Integer> currentNode = list.node;

            while (currentNode != null) {

                if (currentNode.next != null) {

                    if (currentNode.next.data < currentNode.data) {

                        var temp = currentNode.data;
                        currentNode.data = currentNode.next.data;
                        currentNode.next.data = temp;

                        swapped[0] = true;
                    } else if (currentNode.next.data.equals(currentNode.data)) {
                        currentNode.next = currentNode.next.next;
                        swapped[0] = true;
                    }
                }

                currentNode = currentNode.next;
            }

        } while (swapped[0]);
    }

}