package com.github.gabrielbb.structures.impl;

public final class LinkedListImpl<T> {

    public static class Node<T> {

        public T data;
        public Node<T> next;

        private Node(T data) {
            this.data = data;
        }
    }

    public Node<T> node;

    public LinkedListImpl(T... dataArray) {
        add(dataArray);
    }

    public void add(T... dataArray) {

        Node<T> lastNode = node;

        while (lastNode != null && lastNode.next != null) {
            lastNode = lastNode.next;
        }


        for (T data : dataArray) {

            var newNode = new Node<>(data);

            if (lastNode == null) {
                node = newNode;
            } else {
                lastNode.next = newNode;
            }

            lastNode = newNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        Node<T> currentNode = node;

        while (currentNode != null) {
            result.append(currentNode.data);
            result.append(",");
            currentNode = currentNode.next;
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LinkedListImpl)) {
            return false;
        }

        return ((LinkedListImpl) obj).toString().equals(this.toString());
    }
}