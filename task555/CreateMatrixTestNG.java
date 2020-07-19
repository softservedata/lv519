package tst_task555;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task555.CreateMatrix;

public class CreateMatrixTestNG {
	private static CreateMatrix matrixPascal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		matrixPascal = new CreateMatrix();
	}

	@DataProvider (name="matrixDataProvider")
	public Object[][] sumDataProvider() {
		return new Object[][] { { 1 }, 
					            { 1, 1 }, 
					            { 1, 2, 1 }, 
					            { 1, 3, 3, 1 }, 
					            { 1, 4, 6, 4, 1 }, 
					            { 1, 5, 10, 10, 5, 1 } };
	}
	
	@Test(dataProvider = "matrixDataProvider")
	public void matrixPascal_6(Object[][] obj) {
		//Object[][] actual = matrixPascal.matrix(6);
		//Assert.assertArrayEquals(actual, expected);
	}

	@Test
	public void matrixPascal_3() {
		
		int[][] actual = matrixPascal.matrix(3);
		//Assert.assertArrayEquals(actual, expected);
	}

	//@Test//(expected = IllegalArgumentException.class)
	public void matrixPascal_0() {
		int expected = 1;
		int[][] actual = matrixPascal.matrix(0);
		//Assert.assertEquals(actual, expected);
	}

	@Test
	public void matrixPascal_1() {
		int expected = 1;
		int[][] actual = matrixPascal.matrix(1);
		//Assert.assertEquals(actual, expected);
	}

	//@Test//(expected = IllegalArgumentException.class)
	public void matrixPascal_negative() {
		int[][] actual = matrixPascal.matrix(-1);
	}
}
