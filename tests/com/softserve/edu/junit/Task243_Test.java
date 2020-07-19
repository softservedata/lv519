package com.softserve.edu.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.softserve.edu.InputOutput;
import com.softserve.edu.PairValue_DTO;
import com.softserve.edu.Task243;

public class Task243_Test {
	private static Task243 task3;

	@BeforeClass
	public static void setUpBeforeClass() {
		task3 = new Task243();
	}

	@Test
	public void testNaturalA() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		expected.add(new PairValue_DTO(1, 2));
		expected.add(new PairValue_DTO(2, 1));
		List<PairValue_DTO> actual = task3.generateListA(5);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testOneA() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		List<PairValue_DTO> actual = task3.generateListA(1);
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeA() {
		task3.generateListA(-3);
		;
	}

	@Test
	public void testNaturalB() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		expected.add(new PairValue_DTO(5, 5));
		expected.add(new PairValue_DTO(7, 1));
		List<PairValue_DTO> actual = task3.generateListB(50);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testOneB() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		List<PairValue_DTO> actual = task3.generateListB(1);
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeB() {
		task3.generateListB(-20);
	}

	@Test
	public void testObjNaturalA() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		List<PairValue_DTO> actual = task3.SumSquaresList1((new InputOutput(7)));
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testObjNaturalB() {
		List<PairValue_DTO> expected = new ArrayList<PairValue_DTO>();
		List<PairValue_DTO> actual = task3.SumSquaresList2((new InputOutput(14)));
		Assert.assertEquals(expected, actual);
	}
}
