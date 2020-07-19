package com.softserve.edu.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task107;

public class Task107_Test {

	// 4^k<n.
	// p=4^k
	private static Task107 task1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		task1 = new Task107();
	}

	@Test
	public void testFive() {
		int expected;
		int actual;
		expected = 1;
		actual = task1.findNumber(5);
		Assert.assertEquals("Error", expected, actual);
	}

	@Test
	public void testTwo() {
		int expected;
		int actual;
		expected = 0;
		actual = task1.findNumber(2);
		Assert.assertEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegative() {
		task1.findK(new InputOutput(-2));
	}

	@Test
	public void testFiveObj() {
		int expected;
		int actual;
		expected = 1;
		actual = task1.findK(new InputOutput(5));
		Assert.assertEquals("Error", expected, actual);
	}

	@Test
	public void testTwoObj() {
		int expected;
		int actual;
		expected = 0;
		actual = task1.findK(new InputOutput(2));
		Assert.assertEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test4() {
		task1.findK(new InputOutput(0));

	}
}
