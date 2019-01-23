package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter4.CheckBalanced;
import com.github.gabrielbb.algorithms.assignments.chapter4.ListOfDepths;
import com.github.gabrielbb.algorithms.assignments.chapter4.MinimalTree;
import com.github.gabrielbb.algorithms.assignments.chapter4.models.BinaryTree;
import com.github.gabrielbb.algorithms.assignments.chapter4.models.Graph.Node;
import com.github.gabrielbb.algorithms.assignments.chapter4.RouteBetweenNodes;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter4Test {

    @Test
    public void testRouteBetweenNodes() {
        var node1 = new Node();
        var node2 = new Node();
        var node3 = new Node();
        var node4 = new Node();
        var node5 = new Node();
        var node6 = new Node();
        var node7 = new Node();
        var node8 = new Node();
        var node9 = new Node();

        node1.children = new Node[] { node2, node3, node4 };
        node2.children = new Node[] { node6, node7 };
        node7.children = new Node[] { node8, node9 };

        assertTrue(RouteBetweenNodes.findRoute(node1, node9));
        assertFalse(RouteBetweenNodes.findRoute(node1, node5));
    }

    @Test
    public void testMinimalTree() {
        MinimalTree.createBinarySearchTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }

    @Test
    public void testListOfDepths() {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<>(1);

        var second = new BinaryTree.Node<>(2);
        var third = new BinaryTree.Node<>(3);
        second.left = third;
        second.right = third;

        root.left = second;
        root.right = second;

        var nodesByDepths = ListOfDepths.getNodesByDepths(new BinaryTree<>(root));
        System.out.print(nodesByDepths);
    }

    @Test
    public void testCheckBalanced() {
        var tree = new BinaryTree<>(new BinaryTree.Node<>(1));
        var second = new BinaryTree.Node<>(2);
        var third = new BinaryTree.Node<>(3);

        second.left = third;
        second.right = third;

        tree.root.left = second;
        tree.root.right = second;

        assertTrue(CheckBalanced.isBalanced(tree));

        var third2 = new BinaryTree.Node<>(3);
        var forth = new BinaryTree.Node<>(4);
        third2.left = forth;
        second.right = third2;

        assertTrue(CheckBalanced.isBalanced(tree));

        forth.right = new BinaryTree.Node<>(5);
        assertFalse(CheckBalanced.isBalanced(tree));
    }
}
