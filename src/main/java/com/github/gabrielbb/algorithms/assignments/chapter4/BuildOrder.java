package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BuildOrder {

    public static String[] getBuildOrder(String projects[], String[][] dependencies) {

        final Map<String, Graph.Node<String>> projectNodes = new HashMap<>();

        for (String p : projects)
            projectNodes.put(p, new Graph.Node<>(p));

        for (String[] d : dependencies)
            projectNodes.get(d[1]).children.add(projectNodes.get(d[0]));

        final List<String> buildOrder = new LinkedList<>();

        for (Graph.Node<String> node : projectNodes.values())
            compileWithDependencies(node, buildOrder);

        return buildOrder.toArray(String[]::new);
    }

    private static void compileWithDependencies(Graph.Node<String> node, List<String> buildOrder) {
        if (node.visited)
            return;

        node.visited = true;

        for (Graph.Node<String> nodez : node.children)
            compileWithDependencies(nodez, buildOrder);

        buildOrder.add(node.value);
    }
}
