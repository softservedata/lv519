package com.softserve.edu.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task107;

/**
 * An integer number n is given, n>1. Get the largest integer k, at which 4^k
 * less then n.
 * 
 * @author Iryna Polihas
 */
public class Task_107_TestNG {
	private Task107 task1 = new Task107();

	@DataProvider
	public Object[][] validDP() {
		return new Object[][] { { 50, 2 }, { 2, 0 }, { 3, 0 } };
	}

	@DataProvider
	public Object[] inValidDP() {
		return new Object[] { -10, 1 };
	}

	@DataProvider
	public Object[] ValidIntegrationDP() {
		return new Object[][] {{ 2, 0 }};
	}

	/**
	 * @param n        - integer number, n>1
	 * @param expected - max power k, at which 4^k less then n.
	 */
	@Test(dataProvider = "validDP")
	public void ValidData(int n, int expected) {
		int actual;
		actual = task1.calculateMaxPower(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	/**
	 * @param n - integer number, n>1
	 */
	@Test(dataProvider = "inValidDP", expectedExceptions = IllegalArgumentException.class)
	public void InValidData(int n) {
		task1.calculateMaxPower(n);
	}

	/**
	 * @param n        - integer number, n>1
	 * @param expected - max power k, at which 4^k less then n.
	 */
	@Test(dataProvider = "ValidIntegrationDP")
	public void ValidDataIntegration(int n, int expected) {
		int actual;
		actual = task1.findMaxPower(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}
}
