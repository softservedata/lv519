package task881;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FunctionTest {

	private static Operation operation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		operation = new Operation();
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsLessThanZero() {
		Number number = new Number(-10);
		operation.checkNumber(number);

	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsZero() {
		Number number = new Number(0);
		operation.checkNumber(number);
	}

	@Test
	public void checkWhenNumberIsGreaterThanZero() {
		Number number = new Number(10);
		int expect = number.getNumber();
		Number actual = operation.checkNumber(number);
		Assert.assertEquals(actual.getNumber(), expect);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsInTheFirstCategoryLeft() {
		Number number = new Number(-2147483647);
		operation.checkNumber(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsInTheFirstCategoryRight() {
		Number number = new Number(-1);
		operation.checkNumber(number);
	}

	@Test
	public void checkWhenNumberIsInTheSecondCategoryLeft() {
		Number number = new Number(1);
		int expect = number.getNumber();
		Number actual = operation.checkNumber(number);
		Assert.assertEquals(actual.getNumber(), expect);
	}

	@Test
	public void checkWhenNumberIsInTheSecondCategoryRight() {
		Number number = new Number(103621);
		int expect = number.getNumber();
		Number actual = operation.checkNumber(number);
		Assert.assertEquals(actual.getNumber(), expect);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsInTheThirdCategoryLeft() {
		Number number = new Number(103622);
		operation.checkNumber(number);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsInTheThirdCategoryRight() {
		Number number = new Number(2147483647);
		operation.checkNumber(number);
	}

	@Test
	public void checkWhenNumberIsValidAndResultIncludeThree() {
		Number number = new Number(456);
		String expected = "Number include 3";
		String actual = operation.start(number);
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void checkWhenNumberIsValidAndResultNotIncludeThree() {
		Number number = new Number(23);
		String expected = "No 3 in your number";
		String actual = operation.start(number);
		Assert.assertEquals(expected, actual);

	}

	@Test(expected = IllegalArgumentException.class)
	public void checkWhenNumberIsInvalid() {
		Number number = new Number(-456);
		operation.checkNumber(number);
	}

}
