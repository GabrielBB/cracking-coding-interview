package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;
import com.github.gabrielbb.structures.BinaryTreeNode;
import com.github.gabrielbb.structures.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepths {

    public static List<LinkedList<BinaryTreeNode>> getNodesByDepths(BinaryTree tree) {

        var data = new ArrayList<LinkedList<BinaryTreeNode>>();

        search(tree.root, 0, data);
        return data;
    }

    private static void search(BinaryTreeNode node, int depth, List<LinkedList<BinaryTreeNode>> data) {
        if (node == null) return;

        if (data.size() - 1 < depth) data.add(new LinkedList<>());
        data.get(depth).add(node);

        search(node.left, depth + 1, data);
        search(node.right, depth + 1, data);
    }
}
