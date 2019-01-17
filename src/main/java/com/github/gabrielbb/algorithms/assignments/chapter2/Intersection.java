package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.LinkedList;
import com.github.gabrielbb.structures.Stack;
import com.github.gabrielbb.structures.LinkedList.Node;
import com.github.gabrielbb.structures.impl.StackImpl;

public class Intersection {

    public Node<Integer> getFirstCommonNode(LinkedList<Integer> a, LinkedList<Integer> b) {

        Node<Integer> currentA = a.node, currentB = b.node;
        var aStack = new StackImpl<Node<Integer>>(100);
        var bStack = new StackImpl<Node<Integer>>(100);

        while (currentA != null) {
            aStack.push(currentA);
            currentA = currentA.next;
        }

        while (currentB != null) {
            bStack.push(currentB);
            currentB = currentB.next;
        }

        Node<Integer> commonNode = null;

        while (bStack.peek() == aStack.peek()) {
            commonNode = aStack.pop();
            bStack.pop();
        }

        return commonNode;
    }
}