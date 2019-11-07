package com.stone.algorithm;


import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {


    @Test
    public void squareTest() {
        float factor = 0.0001f;
        for (int i = 1; i < 500; ++i) {
            Assert.assertTrue(Math.abs(Math.sqrt(i) - BinarySearch.square(i, factor)) <= factor);
        }
    }

}
