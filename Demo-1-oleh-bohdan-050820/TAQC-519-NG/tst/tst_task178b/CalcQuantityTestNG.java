package tst_task178b;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import task178b.CalcQuantity;

public class CalcQuantityTestNG {
		private CalcQuantity cq;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		cq = new CalcQuantity();
	}

	@DataProvider (name="arrayDataProvider")
	public Object[][] arrayDataProvider() {
		return new Object[][] {{ 0, 11, -18, 0, 123, 2 },
			                   { -4, 15, 19, 0, 123, 1 },
			                   { 9, 27, 111, 9, -27, 5 },
			                   { 10, 20, 51, 5, 100, 1 },
			                   { 11, 11, 11, 112, 0, 0 }
			};     
	}
	
	@Test(dataProvider = "arrayDataProvider")
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
