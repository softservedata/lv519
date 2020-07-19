package task332;

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
			{ 15, "a", 9, "b", 4, "c", 1 , "d" , 1}, 
			{ 1, "a", 1, "b", 0, "c", 0 , "d" , 0}, 
			{ 100000, "a", 26896, "b", 25600, "c", 25600 , "d" , 21904}, 
			{ 25, "a", 16, "b", 4, "c", 4 , "d" , 1}, 
		};
	}

	@DataProvider(name = "inValidDataProvider")
	public Object[] inValidDataProvider() {
		return new Object[] { -15, 0, -2147483647, -1, -25};
	}

	@Test(dataProvider = "inValidDataProvider", expectedExceptions = IllegalArgumentException.class)
	public void checkWhenNumberIsInValid(int arg1) {
		Number number = new Number(arg1);
        operation.checkNumber(number);
	}

	@Test(dataProvider = "validDataProvider")
	public void checkWhenNumberIsValidAndResult(int arg1, String s1, int i1, String s2, int i2, String s3, int i3, String s4, int i4 ) {
		Number number = new Number(arg1);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put(s1,i1);
        expectMap.put(s2,i2);
        expectMap.put(s3,i3);
        expectMap.put(s4,i4);
        Map<String, Integer> actualMap = operation.search(operation.checkNumber(number));
        Assert.assertEquals(expectMap,actualMap);
	}
}