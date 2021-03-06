package com.github.gabrielbb.ctci;

import com.github.gabrielbb.ctci.chapter4.*;
import com.github.gabrielbb.ctci.chapter4.models.BinaryTree;
import com.github.gabrielbb.practicing.structures.Graph.Node;
import com.github.gabrielbb.practicing.structures.BinaryTreeNode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

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

        node1.children = List.of(node2, node3, node4);
        node2.children = List.of(node6, node7);
        node7.children = List.of(node8, node9);

        assertTrue(RouteBetweenNodes.findRoute(node1, node9));
        assertFalse(RouteBetweenNodes.findRoute(node1, node5));
    }

    @Test
    public void testMinimalTree() {
        MinimalTree.createBinarySearchTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
    }

    @Test
    public void testListOfDepths() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        var second = new BinaryTreeNode<>(2);
        var third = new BinaryTreeNode<>(3);
        second.left = third;
        second.right = third;

        root.left = second;
        root.right = second;

        var nodesByDepths = ListOfDepths.getNodesByDepths(new BinaryTree<>(root));
        System.out.print(nodesByDepths);
    }

    @Test
    public void testCheckBalanced() {
        var tree = new BinaryTree<>(new BinaryTreeNode<>(1));
        var second = new BinaryTreeNode<>(2);
        var third = new BinaryTreeNode<>(3);

        second.left = third;
        second.right = third;

        tree.root.left = second;
        tree.root.right = second;

        assertTrue(CheckBalanced.isBalanced(tree));

        var third2 = new BinaryTreeNode<>(3);
        var forth = new BinaryTreeNode<>(4);
        third2.left = forth;
        second.right = third2;

        assertTrue(CheckBalanced.isBalanced(tree));

        forth.right = new BinaryTreeNode<>(5);
        assertFalse(CheckBalanced.isBalanced(tree));
    }

    @Test
    public void testBST() {
        var tree = new BinaryTree<>(new BinaryTreeNode<>(8));
        var second = new BinaryTreeNode<>(5);
        var third = new BinaryTreeNode<>(10);
        tree.root.left = second;
        tree.root.right = third;

        second.left = new BinaryTreeNode<>(4);
        second.right = new BinaryTreeNode<>(6);

        assertTrue(ValidateBST.isBST(tree));
    }

    @Test
    public void testBuildOrder() {
        var projects = new String[] { "a", "b", "c", "d", "e", "f" };
        var dependencies = new String[][] { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" }, { "d", "c" } };

        String[] result = BuildOrder.getBuildOrder(projects, dependencies);
        assertArrayEquals(new String[] { "f", "a", "b", "d", "c", "e" }, result);
    }

    @Test
    public void testWeaver() {
        var first = new LinkedList<Integer>();
        first.add(1);
        first.add(2);

        var second = new LinkedList<Integer>();
        second.add(3);
        second.add(4);

        var results = new ArrayList<LinkedList<Integer>>();

        var prefix = new LinkedList<Integer>();

        Weaver.weave(first, second, prefix, results);

        System.out.println(results);
    }

    @Test
    public void testCheckSubtree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        var second = new BinaryTreeNode<>(2);
        var third = new BinaryTreeNode<>(3);
        second.left = third;
        second.right = third;

        root.left = second;
        root.right = second;

        assertTrue(CheckSubtree.isSubtree(root, third));
    }
}
