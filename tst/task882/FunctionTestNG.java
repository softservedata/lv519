package task882;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionTestNG {

	private static Operation operation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		operation = new Operation();
	}

	@DataProvider(name = "validDataProvider")
	public Object[][] validDataProvider() {
		return new Object[][] { { 25, 25 }, { 15, 15 }, { 2147483647, 2147483647 } };
	}

	@DataProvider(name = "inValidDataProvider")
	public Object[] inValidDataProvider() {
		return new Object[] { -5, 0, -2147483647, -1, -15 };
	}

	@DataProvider(name = "DataProvider")
	public Object[][] DataProvider() {
		return new Object[][] { { 123456, 654321 } };
	}

	@Test(dataProvider = "validDataProvider")
	public void checkWhenNumberIsValid(int arg1, int expected) {
		Number number = new Number(arg1);
		Number actual = operation.checkNumber(number);
		Assert.assertEquals(actual.getNumber(), expected);
	}

	@Test(dataProvider = "inValidDataProvider", expectedExceptions = IllegalArgumentException.class)
	public void checkWhenNumberIsInValid(int arg1) {
		Number number = new Number(arg1);
		operation.checkNumber(number);
	}

	@Test(dataProvider = "DataProvider")
	public void checkWhenNumberIsValidAndResult(int arg1, int expected) {
		Number number = new Number(arg1);
		int actual = operation.inverse(number);
		Assert.assertEquals(expected, actual);
	}

}