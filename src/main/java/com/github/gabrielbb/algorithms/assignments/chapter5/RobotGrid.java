package com.github.gabrielbb.algorithms.assignments.chapter5;

import com.github.gabrielbb.algorithms.assignments.chapter5.RobotGrid.Move.Direction;

public class RobotGrid {

    public static class Move {

        public Direction direction;
        public Move next;

        public static enum Direction {
            RIGHT, DOWN;
        }

        public Move(Direction direction, Move next) {
            this.direction = direction;
            this.next = next;
        }

        public Move() {

        }
    }

    public static Move getRobotPath(boolean[][] grid, int x, int y) {

        if (grid[y][x])
            return null;

        Move move = new Move();

        if (y == grid.length - 1 && x == grid[y].length - 1) {
            return move;
        }

        Move nextMove = null;

        if (y < grid.length - 1) {
            nextMove = getRobotPath(grid, x, y + 1);
            move.direction = Direction.DOWN;
        }

        if (nextMove == null && x < grid[y].length - 1) {
            nextMove = getRobotPath(grid, x + 1, y);
            move.direction = Direction.RIGHT;
        }

        if (nextMove != null) {
            move.next = nextMove;
            return move;
        }

        grid[y][x] = true;

        return null;
    }

};