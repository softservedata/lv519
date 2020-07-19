package com.softserve.edu.testng;

import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task108;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task_108_TestNG {
	private Task108 task2 = new Task108();;

	@DataProvider
	public Object[][] dp() {

		return new Object[][] { { 1, new int[] { 2, 1 } }, { 5, new int[] { 8, 3 } }, { 2, new int[] { 4, 2 } } };
	}

	@Test(dataProvider = "dp")
	public void test108(int n, int[] expected) {
		int[] actual;
		actual = task2.findArr(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNegative108() {
		task2.findArr(-10);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testZero108() {
		task2.findArr(0);
	}

	@Test(dataProvider = "dp")
	public void testObj108(int n, int[] expected) {
		int[] actual;
		actual = task2.findR(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOBJNegative108() {
		task2.findR(new InputOutput(-5));
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testOBJZero108() {
		task2.findR(new InputOutput(0));
	}
}
