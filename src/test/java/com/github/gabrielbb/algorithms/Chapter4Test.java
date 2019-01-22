package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.gabrielbb.algorithms.assignments.chapter4.Node;
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
}
