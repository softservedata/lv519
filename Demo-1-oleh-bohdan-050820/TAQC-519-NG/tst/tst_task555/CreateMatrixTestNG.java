package tst_task555;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task555.CreateMatrix;

public class CreateMatrixTestNG {
	private  CreateMatrix matrixPascal;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		matrixPascal = new CreateMatrix();
	}

	@DataProvider (name="matrixDataProvider")
	public Object[][] matrixDataProvider() {
		return new Object[][] { { 1, new int[] { 1 } }, 
			                    { 2, new int[] { 1, 1 } }, 
			                    { 3, new int[] { 1, 2, 1 } }, 
			                    { 4, new int[] { 1, 3, 3, 1 } }, 
				                { 5, new int[] { 1, 4, 6, 4, 1 } }, 
			                    { 6, new int[] { 1, 5, 10, 10, 5, 1 } } };
	}
	
	@Test(dataProvider = "matrixDataProvider")
	public void matrixPascal_6(int dimension, int[] expected) {
		int[][] actual = matrixPascal.matrix(dimension);
		Assert.assertEquals(actual[dimension-1], expected);
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void matrixPascalZero() {
		matrixPascal.matrix(0);
		
	}
		
	@Test
	public void matrixPascalOne() {
		int expected = 1;
		int[][] actual = matrixPascal.matrix(1);
		Assert.assertEquals(actual[0][0], expected);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void matrixPascalNegative() {
		matrixPascal.matrix(-1);
	}
}
