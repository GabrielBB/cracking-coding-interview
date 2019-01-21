package com.github.gabrielbb.algorithms.assignments.chapter3;

import com.github.gabrielbb.structures.Stack;

public class SortStack {

    private boolean sorted;
    private final Stack<Integer> stack;

    public SortStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void sortStack() {

        do {
            sorted = false;
            Integer min = sort();
            stack.push(min);
        } while (sorted);
    }

    private Integer sort() {

        Integer current = stack.pop();

        if(stack.isEmpty()) {
            return current;
        }

        Integer before = sort();

        if (current > before) {
            stack.push(current);
            sorted = true;
            return before;
        } else {
            stack.push(before);
            return current;
        }
    }
}