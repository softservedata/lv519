package task881;

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
		return new Object[][] { { 1, 1 }, { 10, 10 }, { 103621, 103621 } };
	}

	@DataProvider(name = "inValidDataProvider")
	public Object[] inValidDataProvider() {
		return new Object[] { -10, 0, -2147483647, -1, 103622, 2147483647, -456 };
	}

	@DataProvider(name = "DataProvider")
	public Object[][] DataProvider() {
		return new Object[][] { { 456, "Number include 3" }, { 23, "No 3 in your number" } };
	}

	@Test(dataProvider = "validDataProvider")
	public void checkWhenNumberIsValid(int arg1, int expected) {
		Number number = new Number(arg1);
		Number actual = operation.checkNumber(number);
		Assert.assertEquals(expected, actual.getNumber());
	}

	@Test(dataProvider = "inValidDataProvider", expectedExceptions = IllegalArgumentException.class)
	public void checkWhenNumberIsInValid(int arg1) {
		Number number = new Number(arg1);
		operation.checkNumber(number);
	}

	@Test(dataProvider = "DataProvider")
	public void checkWhenNumberIsValidAndResult(int arg1, String expected) {
		Number number = new Number(arg1);
		String actual = operation.start(number);
		Assert.assertEquals(expected, actual);
	}

}
