package com.github.gabrielbb.algorithms;

import com.github.gabrielbb.algorithms.assignments.chapter8.RobotGrid;
import com.github.gabrielbb.algorithms.assignments.chapter8.RobotGrid.Move;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter5Test {

    @Test
    public void testRobotGrid() {

        boolean[][] grid = new boolean[3][3];

        Move move = RobotGrid.getRobotPath(grid, 0, 0);

        while(move != null) {
            System.out.println(move.direction);
            move = move.next;
        }
    }

}
