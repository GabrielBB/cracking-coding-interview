package com.github.gabrielbb.algorithms.assignments.chapter2;

import com.github.gabrielbb.structures.LinkedList;
import com.github.gabrielbb.structures.Stack;
import com.github.gabrielbb.structures.impl.StackImpl;

public class Palindrome {

    public static boolean isPalindrome(LinkedList<String> list) {

        Stack<String> chars = new StackImpl<>(100);

        LinkedList.Node<String> slowNode = list.node;
        LinkedList.Node<String> fastNode = slowNode;

        boolean odd = false;

        while (slowNode != null) {

            if (fastNode != null) {
                chars.push(slowNode.data);
            } else {
                if (odd) {
                    chars.pop();
                    odd = false;
                }

                if (!chars.pop().equals(slowNode.data))
                    return false;
            }

            slowNode = slowNode.next;

            if (fastNode != null) {

                fastNode = fastNode.next;

                if (fastNode != null)
                    fastNode = fastNode.next;
                else
                    odd = true;
            }

        }

        return true;
    }
}
