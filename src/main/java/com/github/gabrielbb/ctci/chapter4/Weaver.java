package com.github.gabrielbb.ctci.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Weaver {

    /**
     * Weave two lists together in all possible ways. This algorithm works by removing the head from one list,
     * recursing and then doing the same think with the other list.
     *
     * @param first
     * @param second
     * @param prefix
     * @param results
     */
    public static void weave(LinkedList<Integer> first, LinkedList<Integer> second, LinkedList<Integer> prefix,
                      ArrayList<LinkedList<Integer>> results) {

        //One list is empty, add the remainder to the prefix and store the result
        if (first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.add(headFirst);
        weave(first, second, prefix, results);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.add(headSecond);
        weave(first, second, prefix, results);
        prefix.removeLast();
        second.addFirst(headSecond);
    }
}