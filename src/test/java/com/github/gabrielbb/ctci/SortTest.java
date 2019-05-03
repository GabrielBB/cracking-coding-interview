package com.github.gabrielbb.ctci;

import java.util.Arrays;

import com.github.gabrielbb.practicing.sorting.Sortable;
import com.github.gabrielbb.practicing.sorting.impl.BubbleSort;
import com.github.gabrielbb.practicing.sorting.impl.InsertionSort;
import com.github.gabrielbb.practicing.sorting.impl.MergeSort;

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
