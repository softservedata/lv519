package com.softserve.edu.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task108;

public class Task108_Test {

	private static Task108 task2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		task2 = new Task108();
	}

	@Test
	public void testNatural() {
		int[] expected = { 8, 3 };
		int[] actual;
		actual = task2.findArr(5);
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test
	public void testOne() {
		int[] expected = { 2, 1 };
		int[] actual;
		actual = task2.findArr(1);
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testZero() {
		task2.findArr(0);
	}

	@Test
	public void testObjNatural() {
		int[] expected = { 4, 2 };
		int[] actual;
		actual = task2.findR(new InputOutput(2));
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test
	public void testObjOne() {
		int[] expected = { 2, 1 };
		int[] actual;
		actual = task2.findR(new InputOutput(1));
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testObjNegative() {
		task2.findR(new InputOutput(-5));
	}
}
