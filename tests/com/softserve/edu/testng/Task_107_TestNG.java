package com.softserve.edu.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task107;

public class Task_107_TestNG {

	private Task107 task1 = new Task107();;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { { 5, 1 }, { 2, 0 }, { 3, 0 } };
	}

	@Test(dataProvider = "dp", groups = "Test_GROUP")
	public void test107(int n, int expected) {
		int actual;
		actual = task1.findNumber(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOne107() {
		task1.findNumber(1);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNegative107() {
		task1.findNumber(-10);
	}

	@Test(dataProvider = "dp", groups = "TestObject_GROUP")

	public void testObj107(int n, int expected) {
		int actual;
		actual = task1.findK(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOBJOne107() {
		task1.findK(new InputOutput(1));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOBJNegative107() {
		task1.findK(new InputOutput(-5));
	}
}
