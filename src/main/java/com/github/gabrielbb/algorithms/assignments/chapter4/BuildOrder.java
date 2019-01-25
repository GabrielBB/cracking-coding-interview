package com.github.gabrielbb.algorithms.assignments.chapter4;

import com.github.gabrielbb.algorithms.assignments.chapter4.models.Graph;

import java.util.HashMap;
import java.util.Map;

public class BuildOrder {

    public static String[] getBuildOrder(String projects[], String[][] dependencies) {

        Map<String, Graph.Node<String>> projectNodes = new HashMap<>();

        for (String p : projects)
            projectNodes.put(p, new Graph.Node<>(p));

        for (String[] d : dependencies) {
            projectNodes.get(d[0]).children.add(projectNodes.get(d[1]));
        }


        return null;
    }
}
