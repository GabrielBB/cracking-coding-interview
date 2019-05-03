package com.github.gabrielbb.ctci.chapter4;

import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

public class CheckSubtree {

    public static boolean isSubtree(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {

        var t1String = new StringBuilder();
        var t2String = new StringBuilder();

        printNode(t1, t1String);
        printNode(t2, t2String);

        return t1String.toString().contains(t2String);
    }

    private static void printNode(BinaryTreeNode<Integer> node, StringBuilder builder) {

        if (node == null) {
            builder.append("null");
            return;
        }

        builder.append(node.data);

        builder.append("(");

        printNode(node.left, builder);

        builder.append(",");

        printNode(node.right, builder);

        builder.append(")");
    }
}