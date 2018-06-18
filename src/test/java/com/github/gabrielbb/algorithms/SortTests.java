package com.github.gabrielbb.algorithms;

import java.util.Arrays;

import com.github.gabrielbb.algorithms.sort.Sortable;
import com.github.gabrielbb.algorithms.sort.impl.BubbleSort;

import org.junit.Assert;
import org.junit.Test;

public class SortTests {

    @Test
    public void testBubbleSort() {
        testSort(new BubbleSort());
    }

    private void testSort(Sortable sortable) {
        final int[] array = new int[] { 199, 25, 10, 178, 12, 47, 125, 122, 121 };

        final int[] array2 = array.clone();
        Arrays.sort(array2);

        sortable.sort(array);

        Assert.assertArrayEquals(array2, array);
    }
}
