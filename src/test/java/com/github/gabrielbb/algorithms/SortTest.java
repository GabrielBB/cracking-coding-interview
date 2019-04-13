package com.github.gabrielbb.algorithms;

import java.util.Arrays;

import com.github.gabrielbb.algorithms.sort.Sortable;
import com.github.gabrielbb.algorithms.sort.impl.BubbleSort;
import com.github.gabrielbb.algorithms.sort.impl.InsertionSort;
import com.github.gabrielbb.algorithms.sort.impl.MergeSort;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void testBubbleSort() {
        testSort(new BubbleSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    private void testSort(Sortable sortable) {
        final int[] array = new int[] { 1, 5, 8, 0, 4, 6 };

        final int[] array2 = array.clone();
        Arrays.sort(array2);

        sortable.sort(array);

        Assert.assertArrayEquals(array2, array);
    }
}
