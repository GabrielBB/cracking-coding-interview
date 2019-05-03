package com.github.gabrielbb.ctci.chapter10.rankstream.impl;

import com.github.gabrielbb.ctci.chapter10.rankstream.IRank;
import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class BSTRank implements IRank {

    private BinaryTreeNode<Integer> root;

    @Override
    public void track(int... nums) {

        for (int num : nums) {
            var newNode = new BinaryTreeNode<>(num);

            if (root == null) {
                root = newNode;
                continue;
            }

            var node = root;

            while (node != null) {

                newNode.parent = node;

                if (num > node.data) {
                    if (node.right == null) {
                        node.right = newNode;
                        newNode.rank = node.rank + 1;
                        node = null;
                    } else {
                        node = node.right;
                    }
                } else {
                    node.rank++;

                    if (node.left == null) {
                        newNode.rank = node.rank - 1;
                        node.left = newNode;
                        node = null;
                    } else {
                        node = node.left;
                    }
                }
            }
        }
    }

    @Override
    public int getRankOfNumber(int num) throws RuntimeException {

        var node = root;
        while (node != null) {

            if (num == node.data)
                return node.rank;

            node = num > node.data ? node.right : node.left;
        }

        return -1;
    }

}