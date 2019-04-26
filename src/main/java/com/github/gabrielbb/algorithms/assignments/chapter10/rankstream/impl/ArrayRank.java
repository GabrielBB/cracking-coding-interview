package com.github.gabrielbb.algorithms.assignments.chapter10.rankstream.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.gabrielbb.algorithms.assignments.chapter10.rankstream.IRank;

public class ArrayRank implements IRank {

    private final List<Integer> data = new ArrayList<>();

    public void track(int... nums) {

        for (int num : nums) {
            int index = Collections.binarySearch(data, num);

            index = index < 0 ? (index + 1) * -1 : index + 1;

            if (index == data.size()) {
                data.add(num);
            } else {
                data.add(index, num);
            }
        }

    }

    public int getRankOfNumber(int num) {
        int index = Collections.binarySearch(data, num);

        while ((index + 1) < data.size() && data.get(index + 1) == num) {
            index++;
        }

        return index;
    }
}