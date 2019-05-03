package com.github.gabrielbb.ctci.chapter10.rankstream;

public interface IRank {

    void track(int... nums);

    int getRankOfNumber(int num);
}