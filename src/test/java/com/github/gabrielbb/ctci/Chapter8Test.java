package com.github.gabrielbb.ctci;

import com.github.gabrielbb.ctci.chapter8.RobotGrid;
import com.github.gabrielbb.ctci.chapter8.RobotGrid.Move;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Chapter8Test {

    @Test
    public void testRobotGrid() {

        boolean[][] grid = new boolean[3][3];

        Move move = RobotGrid.getRobotPath(grid, 0, 0);

        while(move != null) {
            move = move.next;
        }
    }

}
