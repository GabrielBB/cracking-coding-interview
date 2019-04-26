package com.github.gabrielbb.algorithms.assignments.chapter10.rankstream;

public interface IRank {

    void track(int... nums);

    int getRankOfNumber(int num);
}