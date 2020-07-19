package task322;

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
    
    @Test
    public void checkWhenFirstValueIsGreaterThanZeroAndSecondValueIsGreaterThanZero() {
        Value value = new Value(1,100);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("Max_number",96);
        expectMap.put("Max_k",12);
        Map<String, Integer> actualMap = operation.search(operation.checkValue(value));
        Assert.assertEquals(expectMap,actualMap);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsGreaterThanZeroAndSecondValueIsZero() {
    	Value value = new Value(1,0);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsGreaterThanZeroAndSecondValueIsLessThanZero() {
    	Value value = new Value(1,-1);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsZeroAndSecondValueIsGreaterThanZero() {
    	Value value = new Value(0,1);
        operation.checkValue(value);
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsZeroAndSecondValueIsZero() {
    	Value value = new Value(0,0);
        operation.checkValue(value);
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsZeroAndSecondValueIsLessThanZero() {
    	Value value = new Value(0,-1);
        operation.checkValue(value);
    }
	
	
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsLessThanZeroAndSecondValueIsLessThanZero() {
    	Value value = new Value(-1,-1);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsLessThanZeroAndSecondValueIsZero() {
    	Value value = new Value(-1,0);
        operation.checkValue(value);
    }
	
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsLessThanZeroAndSecondValueIsGreaterThanZero() {
    	Value value = new Value(-1,1);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenValueIsInTheFirstCategory() {
    	Value value = new Value(-2147483647,-1);
        operation.checkValue(value);
    }
    
    @Test
    public void checkWhenValueIsInTheSecondCategory() {
    	Value value = new Value(1,10000);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("Max_number",9240);
        expectMap.put("Max_k",64);
        Map<String, Integer> actualMap = operation.search(operation.checkValue(value));
        Assert.assertEquals(expectMap,actualMap);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenValueIsInTheThirdCategory() {
    	Value value = new Value(10001,2147483647);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsValidAndSecondValueIsInvalid() {
    	Value value = new Value(1,-2);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsInvalidAndSecondValueIsValid() {
    	Value value = new Value(-1,2);
        operation.checkValue(value);
    }
    
    @Test
    public void checkWhenFirstValueIsValidAndSecondValueIsValid() {
    	Value value = new Value(100,200);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("Max_number",180);
        expectMap.put("Max_k",18);
        Map<String, Integer> actualMap = operation.search(operation.checkValue(value));
        Assert.assertEquals(expectMap,actualMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsInvalidAndSecondValueIsInvalid() {
    	Value value = new Value(-1,-2);
        operation.checkValue(value);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenFirstValueIsGreaterThanSecond() {
    	Value value = new Value(5,3);
        operation.checkValue(value);
    }
    
    @Test
    public void checkWhenSecondValueIsGreaterThanSecond() {
    	Value value = new Value(3,5);
        Map<String,Integer> expectMap = new HashMap<>();
        expectMap.put("Max_number",4);
        expectMap.put("Max_k",3);
        Map<String, Integer> actualMap = operation.search(operation.checkValue(value));
        Assert.assertEquals(expectMap,actualMap);
    }
	
}
