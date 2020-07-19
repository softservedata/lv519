package task882;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FunctionTest {
	
	private static Operation operation;
	
	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
		operation = new Operation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsLessThanZero() {
    	Number number = new Number(-5);
        operation.checkNumber(number);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsZero() {
    	Number number = new Number(0);
        operation.checkNumber(number);
    }
    
    @Test
    public void checkWhenNumberIsGreaterThanZero() {
    	Number number = new Number(25);
        int expect = number.getNumber();
        Number actual = operation.checkNumber(number);
        Assert.assertEquals(actual.getNumber(),expect);
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
    	Number number = new Number(15);
        int expect = number.getNumber();
        Number actual = operation.checkNumber(number);
        Assert.assertEquals(actual.getNumber(),expect);
    }
    
    @Test
    public void checkWhenNumberIsInTheSecondCategoryRight() {
    	Number number = new Number(2147483647);
        int expect = number.getNumber();
        Number actual = operation.checkNumber(number);
        Assert.assertEquals(actual.getNumber(),expect);
    }
    
    @Test
    public void checkWhenNumberIsValid() {
    	Number number = new Number(123456);
        int expected = 654321;
        int actual = operation.result(number);
        Assert.assertEquals(expected,actual);
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void checkWhenNumberIsInvalid() {
    	Number number = new Number(-15);
        operation.checkNumber(number);
    }
    
}
