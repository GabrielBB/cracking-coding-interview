package com.github.gabrielbb.ctci;

import com.github.gabrielbb.test.search.Searchable;
import com.github.gabrielbb.test.search.impl.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class SearchTest {

    private final int[] array = new int[] { 10, 12, 25, 47, 120, 121, 122, 178, 199 };

    @Test
    public void testBinarySearch() {
        Searchable binarySearch = new BinarySearch();

        Assert.assertEquals(3, binarySearch.find(array, 47));
        Assert.assertEquals(0, binarySearch.find(array, 10));
        Assert.assertEquals(array.length - 1, binarySearch.find(array, 199));
        Assert.assertEquals(6, binarySearch.find(array, 122));
        Assert.assertEquals(4, binarySearch.find(array, 120));
        Assert.assertEquals(-1, binarySearch.find(array, 500));
    }
}
