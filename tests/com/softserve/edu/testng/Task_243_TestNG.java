package com.softserve.edu.testng;

import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.PairNaturalNumbers_DTO;
import com.softserve.edu.Task243;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task_243_TestNG {
	private Task243 task3 = new Task243();

	@DataProvider
	public Object[][] validDP_A() {
		return new Object[][] {
				{ 5, Arrays.asList(new PairNaturalNumbers_DTO(1, 2), new PairNaturalNumbers_DTO(2, 1)) },
				{ 50, Arrays.asList(new PairNaturalNumbers_DTO(1, 7), new PairNaturalNumbers_DTO(5, 5),
						new PairNaturalNumbers_DTO(7, 1)) },
				{ 2, Arrays.asList(new PairNaturalNumbers_DTO(1, 1)) }, { 1, Arrays.asList() },
				{ 7, Arrays.asList() } };
	}

	@DataProvider
	public Object[][] validDP_B() {
		return new Object[][] { { 5, Arrays.asList(new PairNaturalNumbers_DTO(2, 1)) },
				{ 50, Arrays.asList(new PairNaturalNumbers_DTO(5, 5), new PairNaturalNumbers_DTO(7, 1)) },
				{ 2, Arrays.asList(new PairNaturalNumbers_DTO(1, 1)) }, { 1, Arrays.asList() },
				{ 7, Arrays.asList() } };
	}

	@DataProvider
	public Object[] inValidDP() {
		return new Object[] { -5, 0 };
	}

	@DataProvider
	public Object[][] validDP_Integration() {
		return new Object[][] { { 1, Arrays.asList() } };
	}

	@Test(dataProvider = "validDP_A")
	public void test_A_ValidData(int n, List<PairNaturalNumbers_DTO> expected) {
		List<PairNaturalNumbers_DTO> actual;
		actual = task3.calculateListOfNumber(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(dataProvider = "inValidDP", expectedExceptions = IllegalArgumentException.class)
	public void test_A_InValidData(int n) {
		task3.calculateListOfNumber(n);
	}

	@Test(dataProvider = "validDP_B")
	public void test_B_ValidData(int n, List<PairNaturalNumbers_DTO> expected) {
		List<PairNaturalNumbers_DTO> actual;
		actual = task3.calculateListOfSpecNumbers(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(dataProvider = "inValidDP", expectedExceptions = IllegalArgumentException.class)
	public void test_B_InValidData(int n) {
		task3.calculateListOfSpecNumbers(n);
	}

	@Test(dataProvider = "validDP_Integration")
	public void test_A_ValidDataIntegration(int n, List<PairNaturalNumbers_DTO> expected) {
		List<PairNaturalNumbers_DTO> actual;
		actual = task3.ListOfSumSquares(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(dataProvider = "validDP_Integration")
	public void test_B_ValidDataIntegration(int n, List<PairNaturalNumbers_DTO> expected) {
		List<PairNaturalNumbers_DTO> actual;
		actual = task3.ListOfSpecSumSquares(new InputOutput(n));
		Assert.assertEquals(actual, expected, "Error");
	}
}
