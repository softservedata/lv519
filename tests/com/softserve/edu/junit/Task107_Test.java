package com.softserve.edu.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task107;

/**
 * An integer number n is given, n>1. Get the largest integer k, at which 4^k
 * less then n.
 * 
 * @author Iryna Polihas
 */
public class Task107_Test {
	private static Task107 task1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		task1 = new Task107();
	}

	@Test
	public void testValidFifty() {
		int expected;
		int actual;
		expected = 2;
		actual = task1.calculateMaxPower(50);
		Assert.assertEquals("Error", expected, actual);
	}

	@Test
	public void testValidTwo() {
		int expected;
		int actual;
		expected = 0;
		actual = task1.calculateMaxPower(2);
		Assert.assertEquals("Error", expected, actual);
	}

	@Test
	public void testValidThree() {
		int expected;
		int actual;
		expected = 0;
		actual = task1.calculateMaxPower(3);
		Assert.assertEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidNegative() {
		task1.calculateMaxPower(-10);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOne() {
		task1.calculateMaxPower(1);
	}
	
	@Test
	public void testValidTwoIntegration() {
		int expected;
		int actual;
		expected = 0;
		actual = task1.findMaxPower(new InputOutput(2));
		Assert.assertEquals("Error", expected, actual);
	}
}
