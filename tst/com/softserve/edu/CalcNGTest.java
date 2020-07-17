package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcNGTest {

    @DataProvider // (parallel = true)
    public Object[][] addDataProvider() {
        return new Object[][] {
            { 4, 4, 8 }, { 3, 5, 8 }
            };
    }

    @Test(dataProvider = "addDataProvider")
    public void testAdd1(double arg0, double arg1, double expected) {
        System.out.println("\t\t@Test testAdd1()");
        String message = "Test testAdd1() Error: arg0= %.2f arg1= %.2f expected= %.2f";
        Calc calc = new Calc();
        // double expected;
        double actual;
        //
        //expected = 8;
        actual = calc.add(arg0, arg1);
        Assert.assertEquals(actual, expected, 0.001, String.format(message, arg0, arg1, expected));
    }


    //@Test
    public void testDiv1() {
        System.out.println("\t\t@Test testDiv1()");
        // fail("Not yet implemented");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 5;
        actual = calc.div(20, 4);
        //Assert.assertEquals("Error 20/4", expected, actual, 0.001);
    }

    //@Test
    public void testDiv2() {
        System.out.println("\t\t@Test testDiv2()");
        // fail("Not yet implemented");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        //Assert.assertEquals("Error 20/4", expected, actual, 0.001);
    }
}
