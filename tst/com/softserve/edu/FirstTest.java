package com.softserve.edu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FirstTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("\t@BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("\t@AfterTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("\t\t@BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("\t\t@AfterClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("\t\t\t@BeforeMethod");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("\t\t\t@AfterMethod");
    }

    @Test
    public void f1() {
        System.out.println("\t\t\t\t@Test f1()");
    }

    @Test
    public void f2() {
        System.out.println("\t\t\t\t@Test f2()");
    }
}
