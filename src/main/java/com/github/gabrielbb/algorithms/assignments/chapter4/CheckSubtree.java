package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;

public class CheckSubtree {

    public static boolean isSubtree(BinaryTree<Integer> t1, BinaryTree<Integer> t2) {

        var t1String = new StringBuilder();
        var t2String = new StringBuilder();

        printTree(t1, t1String);
        printTree(t2, t2String);

        return t1String.toString().contains(t2String);
    }

    private static void printTree(BinaryTree<Integer> tree, StringBuilder builder) {
        
    }
}