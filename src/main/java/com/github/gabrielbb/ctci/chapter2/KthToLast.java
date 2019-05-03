package com.github.gabrielbb.ctci.chapter2;

import com.github.gabrielbb.practicing.structures.LinkedList;
import com.github.gabrielbb.practicing.structures.LinkedList.Node;

public class KthToLast {

    public static int findKthToLast(LinkedList<Integer> list, int k) {

        Node<Integer> c = list.node;
        Node<Integer> c2 = c;

        for(int i = 0; i <= k; i++) {

            if(c2.next == null) {
                // Out of bounds
                return -1;
            }

            c2 = c2.next;
        }

        while (c2 != null) {
            c = c.next;
            c2 = c2.next;
        }

        return c.data;
    }
}