package com.github.gabrielbb.algorithms;

import java.util.Arrays;

import com.github.gabrielbb.algorithms.assignments.chapter10.SortedMerge;

import org.junit.Assert;
import org.junit.Test;

public class Chapter10Test {

    @Test
    public void testSortedMerge() {
        final int[] a = new int[5];
        a[0] = 2;
        a[1] = 4;

        final int[] b = new int[] { 1, 1000, 2000 };

        final int[] sorted = a.clone();
    
        for(int i = a.length - b.length; i < a.length; i++) {
            sorted[i] = b[i + (b.length - a.length)];
        }

        Arrays.sort(sorted);

        SortedMerge.sort(a, b);

        Assert.assertArrayEquals(a, sorted);
    }
}
