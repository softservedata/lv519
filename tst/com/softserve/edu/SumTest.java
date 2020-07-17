package com.softserve.edu;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SumTest {
    private static final double DELTA = 0.001;
    private static Sum sum;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        sum = new Sum();
    }
    
    @Test
    public void testAdd1() {
        double expected;
        double actual;
        //
        expected = 8.001;
        actual = sum.add(4, 4);
        Assert.assertEquals("Error 4+4", expected, actual, DELTA);
    }
    
    @Test
    public void testAdd2() {
        double expected;
        double actual;
        //
        expected = 8;
        actual = sum.add(5, 3);
        Assert.assertEquals("Error 5+3", expected, actual, DELTA);
    }
}
