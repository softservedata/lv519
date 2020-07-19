package task322;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FunctionTestNG {

	private static DataOperation operation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		operation = new DataOperation();
	}

	@DataProvider(name = "validDataProvider")
	public Object[][] validDataProvider() {
		return new Object[][] { 
			{ 1, 100, "Max_number", 96, "Max_k", 12 }, { 1, 10000, "Max_number", 9240, "Max_k", 64 }, 
			{ 100, 200, "Max_number", 180, "Max_k", 18 }, { 3, 5, "Max_number", 4, "Max_k", 3 }
		};
	}

	@DataProvider(name = "inValidDataProvider")
	public Object[][] inValidDataProvider() {
		return new Object[][] { 
			{ 1, 0 }, { 1, -1 }, { 0, 1 }, 
			{ 0, 0 }, { 0, -1 }, { -1, -1 }, 
			{ -1, 0 }, { -1, 1 }, { -2147483647, -1 }, 
			{ 10001, 2147483647 }, { 1, -2 }, { -1, 2 }, 
			{ -1, -2 }, { 5 , 3 }
		};
	}

	@Test(dataProvider = "inValidDataProvider", expectedExceptions = IllegalArgumentException.class)
	public void checkWhenNumberIsInValid(int arg1, int arg2) {
		Value value = new Value(arg1, arg2);
        operation.checkValue(value);
	}

	@Test(dataProvider = "validDataProvider")
	public void checkWhenNumberIsValidAndResult(int arg1, int arg2, String ex1, int ex11, String ex2, int ex22) {
		Value value = new Value(arg1, arg2);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put(ex1,ex11);
        expectMap.put(ex2,ex22);
        Map<String, Integer> actualMap = operation.search(operation.checkValue(value));
        Assert.assertEquals(expectMap,actualMap);
	}
}
