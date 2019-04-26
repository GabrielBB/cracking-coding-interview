package com.github.gabrielbb.algorithms;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import com.github.gabrielbb.algorithms.assignments.chapter10.GroupAnagrams;
import com.github.gabrielbb.algorithms.assignments.chapter10.SortedMatrixSearch;
import com.github.gabrielbb.algorithms.assignments.chapter10.SortedMerge;
import com.github.gabrielbb.algorithms.assignments.chapter10.SortedSearchNoSize;
import com.github.gabrielbb.algorithms.assignments.chapter10.SparseSearch;
import com.github.gabrielbb.algorithms.assignments.chapter10.SortedSearchNoSize.Listy;

import org.junit.Assert;
import org.junit.Test;

public class Chapter10Test {

    @Test
    public void testSortedMerge() {
        final var a = new int[5];
        a[0] = 2;
        a[1] = 4;

        final var b = new int[] { 1, 1000, 2000 };

        final var sorted = a.clone();

        for (int i = a.length - b.length; i < a.length; i++) {
            sorted[i] = b[i + (b.length - a.length)];
        }

        Arrays.sort(sorted);

        SortedMerge.sort(a, b);

        assertArrayEquals(a, sorted);
    }

    @Test
    public void testGroupAnagrams() {
        var array = new String[] { "casa", "", "perro", "scaa", "__", "dawdas", "oerrp" };
        GroupAnagrams.sort(array);
        Assert.assertArrayEquals(new String[] { "casa", "scaa", "perro", "oerrp", "__", "dawdas", "" }, array);
    }

    @Test
    public void testSortedSearchNoSize() {
        assertEquals(3, SortedSearchNoSize.search(new Listy(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }), 3));
        assertEquals(5,
                SortedSearchNoSize.search(new Listy(new int[] { 0, 10000, 100000, 200000, 200000, 300000 }), 300000));
        assertEquals(3,
                SortedSearchNoSize.search(new Listy(new int[] { 0, 10000, 100000, 200000, 200000, 300000 }), 200000));
    }

    @Test
    public void testSparseSearch() {
        assertEquals(4, SparseSearch.findString("ball",
                new String[] { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" }));
    }

    @Test
    public void testSortedMatrixSearch() {
        int[][] matrix = new int[][] { new int[] { 1, 2, 2, 4 }, new int[] { 2, 2, 4, 5 }, new int[] { 3, 4, 5, 6 }, new int[] { 4, 5, 6, 7 }};

        assertArrayEquals(new int[] { 2, 0 }, SortedMatrixSearch.search(matrix, 3));
        assertArrayEquals(new int[] { 3, 3 }, SortedMatrixSearch.search(matrix, 7));
        assertArrayEquals(new int[] { 0, 0 }, SortedMatrixSearch.search(matrix, 1));
        assertArrayEquals(null, SortedMatrixSearch.search(matrix, 8));
        assertArrayEquals(null, SortedMatrixSearch.search(matrix, -1));
    }
}
