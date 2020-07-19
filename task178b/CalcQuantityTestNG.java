package tst_task178b;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import task178b.CalcQuantity;

public class CalcQuantityTestNG {
		private static CalcQuantity cq;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cq = new CalcQuantity();
	}

	@DataProvider (name="sumDataProvider")
	public Object[][] sumDataProvider() {
		return new Object[][] {{ 31, 15, 18, 31, 123, 2 },
			                   { 34, 15, 19, 31, 123, 1 },
			                   { 15, 15, 30, 45, 60, 0 },
			                   { 9, 27, 6, 9, 27, 5 },
			                   { 10, 20, 5, 5, 100, 0 },
			                   { 11, 11, 11, 11, 11, 0 }
			};     
	}
	
	@Test(dataProvider = "sumDataProvider")
	void testNumberFigures(int a1,int a2,int a3,int a4,int a5,int a6) {
		List<Integer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		list.add(a4);
		list.add(a5);
				
		int actual = cq.numberFigures(list);
		int expected = a6;
		Assert.assertEquals(actual, expected);
	}

}
