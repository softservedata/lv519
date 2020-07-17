package com.softserve.edu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("@BeforeClass setUpBeforeClass()");
        // throw new RuntimeException("Ha-Ha-Ha");
    }

    @BeforeClass
    public static void setUpBeforeClass2() throws Exception {
        System.out.println("@BeforeClass setUpBeforeClass2()");
        // throw new RuntimeException("Ha-Ha-Ha");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("@AfterClass tearDownAfterClass()");
        // throw new RuntimeException("Ha-Ha-Ha");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("\t@Before setUp()");
        // throw new RuntimeException("Ha-Ha-Ha");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\t@After tearDown()");
        // throw new RuntimeException("Ha-Ha-Ha");
    }

    // @Test
    public void testAdd() {
        System.out.println("\t\t@Test testAdd()");
        // int i = 0;
        double i = 0;
        System.out.println("\t\t\tresult = " + 10 / i);
        if (i == 0) {
            // throw new RuntimeException("Ha-Ha-Ha");
        }
        // fail("Not yet implemented");
    }

    @Test
    public void testAdd1() {
        System.out.println("\t\t@Test testAdd1()");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 8;
        actual = calc.add(4, 4);
        Assert.assertEquals("Error 4+4", expected, actual, 0.001);
    }
    
    @Test
    public void testAdd2() {
        System.out.println("\t\t@Test testAdd2()");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 8;
        actual = calc.add(5, 3);
        Assert.assertEquals("Error 5+3", expected, actual, 0.001);
    }

    @Test
    public void testDiv1() {
        System.out.println("\t\t@Test testDiv1()");
        // fail("Not yet implemented");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 5;
        actual = calc.div(20, 4);
        Assert.assertEquals("Error 20/4", expected, actual, 0.001);
    }

    @Test
    public void testDiv2() {
        System.out.println("\t\t@Test testDiv2()");
        // fail("Not yet implemented");
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        Assert.assertEquals("Error 20/4", expected, actual, 0.001);
    }
}
