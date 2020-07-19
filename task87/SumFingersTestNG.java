package tst_task87;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task87.SumFingers;

public class SumFingersTestNG {

	private static SumFingers sumFin;
	
	@BeforeClass
	public static void setUpBeforeClass()  {
		sumFin = new SumFingers();
	}

	 @DataProvider // (parallel = true)
	    public Object[][] sumDataProvider() {
	        return new Object[][] {
	            { 31456, 3, 15 }, 
	            { 425627, 4, 20 }, 
	            { 425627, 6, 26 }
	            };
	    }
	 @DataProvider // (parallel = true)
	    public Object[][] sumDataProvider1() {
	        return new Object[][] {
	            { 3, 0 }, { 0, 0 }
	            };
	    }
	    @Test(dataProvider = "sumDataProvider")
	    public void testSumNumbers(int n, int m, int expected) {
	        System.out.println("\t\t@Test testSumNumbers()");
	        String message = "Test testAdd1() Error: n= %d m= %d expected= %d";
	        int actual;
	        actual = sumFin.sumNumbers(n, m);
	        Assert.assertEquals(actual, expected, 0.001, String.format(message, n, m, expected));
	    }
	    
	    @Test(dataProvider = "sumDataProvider1")
	    public void testSumNumbersZeroM(int n, int m) {
			int expected = 0;
			int actual = sumFin.sumNumbers(n, m);
			Assert.assertEquals(actual, expected,"Error for zero");
		}
	   
	    /*-
	 	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void sumNumbersZeroN() {
		int actual = sum.sumNumbers(0, 3);	
	}
	@Test//(expected = Exception.class)
		public void sumNumbersNegativeN() {
			//int expected = 0;
			int actual = sumFin.sumNumbers(-2, 2);
			Assert.assertEquals(actual, expected,"Error for zero");
		}	
	
	
	*/
}
