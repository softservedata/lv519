package com.softserve.edu.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.PairNaturalNumbers_DTO;
import com.softserve.edu.Task243;

/**
 * Given a natural number n. Is it possible to represent it as the sum of
 * squares of two natural numbers? <br>
 * a) If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2; <br>
 * b) If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2 and x>=y.
 * 
 * @author Iryna Polihas
 */
public class Task243_Test {
	private static Task243 task3;

	@BeforeClass
	public static void setUpBeforeClass() {
		task3 = new Task243();
	}

	@Test
	public void test_A_ValidNaturalFive() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(1, 2));
		expected.add(new PairNaturalNumbers_DTO(2, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfNumber(5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_A_ValidNaturalOne() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfNumber(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_A_ValidNaturalTwo() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(1, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfNumber(2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_A_ValidNaturalSeven() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfNumber(7);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_A_ValidNaturalFifty() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(1, 7));
		expected.add(new PairNaturalNumbers_DTO(5, 5));
		expected.add(new PairNaturalNumbers_DTO(7, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfNumber(50);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_A_InValidNegative() {
		task3.calculateListOfNumber(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_A_InValidZero() {
		task3.calculateListOfNumber(0);
	}

	@Test
	public void test_B_ValidNaturalFive() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(2, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfSpecNumbers(5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_B_ValidNaturalOne() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfSpecNumbers(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_B_ValidNaturalTwo() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(1, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfSpecNumbers(2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_B_ValidNaturalSeven() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfSpecNumbers(7);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_B_ValidNaturalFifty() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		expected.add(new PairNaturalNumbers_DTO(5, 5));
		expected.add(new PairNaturalNumbers_DTO(7, 1));
		List<PairNaturalNumbers_DTO> actual = task3.calculateListOfSpecNumbers(50);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_B_InValidNegative() {
		task3.calculateListOfSpecNumbers(-5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_B_InValidZero() {
		task3.calculateListOfSpecNumbers(0);
	}
	
	@Test
	public void test_A_ValidNaturalOneIntegration() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.ListOfSumSquares(new InputOutput(1));
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test_B_ValidNaturalOneIntegration() {
		List<PairNaturalNumbers_DTO> expected = new ArrayList<PairNaturalNumbers_DTO>();
		List<PairNaturalNumbers_DTO> actual = task3.ListOfSpecSumSquares(new InputOutput(1));
		Assert.assertEquals(expected, actual);
	}

}