package com.softserve.edu.testng;

import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task108;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

/**
 * An integer number n is given. Get the smallest number 2^k, which exceeds n,
 * (2 ^ k> n).
 * 
 * @author Iryna Polihas
 *
 */
public class Task_108_TestNG {
	private Task108 task2 = new Task108();;

	@DataProvider
	public Object[][] validDP() {
		return new Object[][] { { 50, new int[] { 6, 64 } }, { 1, new int[] { 1, 2 } }, { 2, new int[] { 2, 4 } } };
	}

	@DataProvider
	public Object[] inValidDP() {
		return new Object[] { -5, 0 };
	}

	@DataProvider
	public Object[] ValidIntegrationDP() {
		return new Object[][] { { 1, new int[] { 1, 2 } } };
	}

	/**
	 * @param n        - integer number, n>0
	 * @param expected - array of power k and smallest number 2^k, which exceeds n
	 */
	@Test(dataProvider = "validDP")
	public void testValidData(int n, int[] expected) {
		int[] actual;
		actual = task2.calculateMinResult(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	/**
	 * @param n - integer number, n>0
	 */
	@Test(dataProvider = "inValidDP", expectedExceptions = IllegalArgumentException.class)
	public void testInValidData(int n) {
		task2.calculateMinResult(n);
	}

	/**
	 * @param n        - integer number, n>0
	 * @param expected - array of power k and smallest number 2^k, which exceeds n
	 */
	@Test(dataProvider = "ValidIntegrationDP")
	public void testValidDataIntegration(int n, int[] expected) {
		int[] actual;
		actual = task2.findMinResult(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}
}
