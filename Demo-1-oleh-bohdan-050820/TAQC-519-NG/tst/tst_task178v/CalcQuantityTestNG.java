package tst_task178v;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task178v.CalcQuantity;

public class CalcQuantityTestNG {
		private CalcQuantity cq;

	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		cq = new CalcQuantity();
	}

	@DataProvider (name="arrayDataProvider")
	public Object[][] arrayDataProvider() {
		return new Object[][] {{ 31, 324, 16, 144, 123, 3 },
			                   { -31, 15, 18, 31, 123, 0 },
			                   { 0, 0, 0, 0, 0, 5 },
			                   { -1, -1, -1, -1, -1, 0 },
			                   { 1, 1, 1, 1, 1, 0 }
			                   
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
