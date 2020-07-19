package com.softserve.edu.testng;

import org.testng.annotations.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.PairValue_DTO;
import com.softserve.edu.Task243;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Task_243_TestNG {
	private Task243 task3 = new Task243();

	@DataProvider
	public Object[][] dp1() {
		return new Object[][] { { 5, Arrays.asList(new PairValue_DTO(1, 2), new PairValue_DTO(2, 1)) },
				{ 50, Arrays.asList(new PairValue_DTO(1, 7), new PairValue_DTO(5, 5), new PairValue_DTO(7, 1)) },
				{ 2, Arrays.asList(new PairValue_DTO(1, 1)) }, { 1, Arrays.asList() }, { 7, Arrays.asList() }};
	}
	
	@DataProvider
	public Object[][] dp2() {
		return new Object[][] { { 5, Arrays.asList(new PairValue_DTO(2, 1)) },
				{ 50, Arrays.asList(new PairValue_DTO(5, 5), new PairValue_DTO(7, 1)) },
				{ 2, Arrays.asList(new PairValue_DTO(1, 1)) }, { 1, Arrays.asList() }, { 7, Arrays.asList() }};
	}

	@Test(dataProvider = "dp1")
	public void test243a(int n, List<PairValue_DTO> expected) {
		List<PairValue_DTO> actual;
		actual = task3.generateListA(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNegative243a() {
		List<PairValue_DTO> actual;
		actual = task3.generateListA(-5);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testZero243a() {
		List<PairValue_DTO> actual;
		actual = task3.generateListA(0);
	}
	
	@Test(dataProvider = "dp2")
	public void test243b(int n, List<PairValue_DTO> expected) {
		List<PairValue_DTO> actual;
		actual = task3.generateListB(n);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testNegative243b() {
		List<PairValue_DTO> actual;
		actual = task3.generateListB(-5);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testZero243b() {
		List<PairValue_DTO> actual;
		actual = task3.generateListB(0);
	}
	
}
/*
 * @DataProvider public Object[][] dp() { Map<Integer, List<PairValue_DTO>> map
 * = new HashMap<>(); map.put(5, Arrays.asList(new PairValue_DTO(1, 2), new
 * PairValue_DTO(2, 1))); return new Object[][] { { map } }; } }
 * 
 * @Test(dataProvider = "dp") public void test107(Map<Integer,
 * List<PairValue_DTO>> map) { List<PairValue_DTO> actual =
 * task3.generateListA(map); Assert.assertEquals(actual, map., "Error"); }
 */
