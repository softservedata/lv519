package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
    
    @Test
    public void checkApp1() {
        //WebDriverManage wdm = new WebDriverManage();
        //System.out.println("*** WDM status: " + wdm.init());
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
