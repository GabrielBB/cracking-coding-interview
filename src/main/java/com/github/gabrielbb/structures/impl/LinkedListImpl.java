package com.github.gabrielbb.structures.impl;

import java.util.function.Predicate;

import com.github.gabrielbb.structures.LinkedList;

public class LinkedListImpl<T> implements LinkedList<T> {

    public Node<T> firstNode, lastNode;

    public Node<T> add(T data) {
        Node<T> newNode = new Node<>(data);

        if (lastNode != null) {
            lastNode.next = newNode;
        }

        if (firstNode == null) {
            firstNode = newNode;
        }

        return lastNode = newNode;
    }

    public Node<T> delete(Predicate<T> predicate) {

        if (firstNode != null) {
            Node<T> currentNode = firstNode;
            Node<T> prevNode = null;

            do {
                if (predicate.test(currentNode.data)) {

                    if (prevNode != null) {
                        prevNode.next = currentNode.next;
                    }

                    return currentNode;
                }

                prevNode = currentNode;
            } while ((currentNode = currentNode.next) != null);
        }

        return null;
    }
}