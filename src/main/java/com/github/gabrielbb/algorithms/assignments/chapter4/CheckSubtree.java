package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class CheckSubtree {

    public static boolean isSubtree(BinaryTree.Node<Integer> t1, BinaryTree.Node<Integer> t2) {

        var t1String = new StringBuilder();
        var t2String = new StringBuilder();

        printNode(t1, t1String);
        printNode(t2, t2String);

        return t1String.toString().contains(t2String);
    }

    private static void printNode(BinaryTree.Node<Integer> node, StringBuilder builder) {

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