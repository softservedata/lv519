package task332;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FunctionTest {
	
	private static DataOperation operation;

	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
		operation = new DataOperation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsLessThanZero() {
    	Number number = new Number(-15);
        operation.checkNumber(number);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsZero() {
    	Number number = new Number(0);
        operation.checkNumber(number);
    }
    
    @Test
    public void checkWhenNumberIsGreaterThanZero() {
    	Number number = new Number(15);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("a",9);
        expectMap.put("b",4);
        expectMap.put("c",1);
        expectMap.put("d",1);
        Map<String, Integer> actualMap = operation.search(operation.checkNumber(number));
        Assert.assertEquals(expectMap,actualMap);
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
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("a",1);
        expectMap.put("b",0);
        expectMap.put("c",0);
        expectMap.put("d",0);
        Map<String, Integer> actualMap = operation.search(operation.checkNumber(number));
        Assert.assertEquals(expectMap,actualMap);
    }
    
    @Test
    public void checkWhenNumberIsInTheSecondCategoryRight() {
    	Number number = new Number(100000);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("a",26896);
        expectMap.put("b",25600);
        expectMap.put("c",25600);
        expectMap.put("d",21904);
        Map<String, Integer> actualMap = operation.search(operation.checkNumber(number));
        Assert.assertEquals(expectMap,actualMap);
    }
    
    @Test
    public void checkWhenNumberIsValid() {
    	Number number = new Number(25);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("a",16);
        expectMap.put("b",4);
        expectMap.put("c",4);
        expectMap.put("d",1);
        Map<String, Integer> actualMap = operation.search(operation.checkNumber(number));
        Assert.assertEquals(expectMap,actualMap);
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsInvalid() {
        Number number = new Number(-25);
        operation.checkNumber(number);
    }
	
}
