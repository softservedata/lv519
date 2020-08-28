package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    
    @Test
    public void checkApp1() {
        System.out.println("***surefire.application.secret = " + System.getProperty("surefire.application.secret"));
        Assert.assertTrue(true);
    }
    
    @Test
    public void checkApp2() {
        System.out.println("***surefire.application.password = " + System.getProperty("surefire.application.password"));
        System.out.println("***System.getenv().MY_PASSWORD = " + System.getenv().get("MY_PASSWORD"));
        System.out.println("***System.getenv().MY_IDE = " + System.getenv().get("MY_IDE"));
        Assert.assertTrue(true);
    }
}
