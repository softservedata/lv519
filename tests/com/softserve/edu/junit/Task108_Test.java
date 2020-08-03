package com.softserve.edu.junit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.Task108;

/**
 *  An integer number n is given. Get the smallest number 2^k, which exceeds n, (2 ^ k> n).
 *  
 * @author Iryna Polihas
 */
public class Task108_Test {

	private static Task108 task2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		task2 = new Task108();
	}

	@Test
	public void testValidFifty() {
		int[] expected = { 6, 64 };
		int[] actual;
		actual = task2.calculateMinResult(50);
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test
	public void testValidOne() {
		int[] expected = { 1, 2 };
		int[] actual;
		actual = task2.calculateMinResult(1);
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test
	public void testValidTwo() {
		int[] expected = { 2, 4 };
		int[] actual;
		actual = task2.calculateMinResult(2);
		Assert.assertArrayEquals("Error", expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInValidNegative() {
		task2.calculateMinResult(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInValidZero() {
		task2.calculateMinResult(0);
	}
	@Test
	public void testValidOneIntegration() {
		int[] expected = { 1, 2 };
		int[] actual;
		actual = task2.findMinResult(new InputOutput(1));
		Assert.assertArrayEquals("Error", expected, actual);
	}

}
