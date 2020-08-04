package tst_task87;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task87.SumFingers;

public class SumFingersTestNG {

	private SumFingers sumFin;

	@BeforeClass
	public void setUpBeforeClass() {
		sumFin = new SumFingers();
	}

	@DataProvider
	public Object[][] sumDataProvider() {
		return new Object[][] { { 1, 1, 1 }, 
			                    { 31456, 3, 15 }, 
			                    { 2147483647, 4, 20 } };
	}

	@DataProvider
	public Object[][] sumDataProvider1() {
		return new Object[][] { { 1, 0 }, 
			                    {-1, 0 },
			                    { 0, 0 } };
	}

	@Test(dataProvider = "sumDataProvider")
	public void testSumNumbers(int n, int m, int expected) {
		int actual;
		actual = sumFin.sumNumbers(n, m);
		Assert.assertEquals(actual, expected, "Error");
	}

	@Test(dataProvider = "sumDataProvider1")
	public void testSumNumbersZeroM(int n, int m) {
		int expected = 0;
		int actual = sumFin.sumNumbers(n, m);
		Assert.assertEquals(actual, expected, "Error for zero");
	}

	@Test(expectedExceptions = StringIndexOutOfBoundsException.class)
	public void sumNumbersMGreaterN() {
		sumFin.sumNumbers(314561, 7);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void sumNumbersNegativeN() {
		sumFin.sumNumbers(-2, 2);
	}

	@Test(expectedExceptions = StringIndexOutOfBoundsException.class)
	public void sumNumbersNegativeN1() {
		sumFin.sumNumbers(1, -2);
	}

	@Test(expectedExceptions = StringIndexOutOfBoundsException.class)
	public void sumNumbersNegativeN2() {
		sumFin.sumNumbers(-1, -2);
	}

	@Test(expectedExceptions = StringIndexOutOfBoundsException.class)
	public void sumNumbersZeroN() {
		sumFin.sumNumbers(0, 2);
	}

	@Test(expectedExceptions = StringIndexOutOfBoundsException.class)
	public void sumNumbersZeroN1() {
		sumFin.sumNumbers(0, -2);
	}

}
