package com.github.gabrielbb.ctci.chapter2;

import com.github.gabrielbb.practicing.structures.LinkedList;

public class RemoveDups {

    public static void removeDups(LinkedList<Integer> list) {

        LinkedList.Node<Integer> currentNode = list.node;

        while (currentNode != null) {

            LinkedList.Node<Integer> secondPointer = currentNode;

            while(secondPointer != null && secondPointer.next != null) {

                if(secondPointer.next.data.equals(currentNode.data)) {
                    secondPointer.next = secondPointer.next.next;
                }

                secondPointer = secondPointer.next;
            }

            currentNode = currentNode.next;
        }
    }

    public static void removeDupsWhileSorting(LinkedList<Integer> list) {

        var swapped = new boolean[1];

        do {
            swapped[0] = false;

            LinkedList.Node<Integer> currentNode = list.node;

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