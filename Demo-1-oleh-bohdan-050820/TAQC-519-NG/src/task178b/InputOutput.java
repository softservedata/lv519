package task178b;

import java.util.Arrays;
import java.util.List;

public class InputOutput {
	
	public List<Integer> setArray() {
		Integer[] arr = { 9, 12, 31, 28, 31, 30, 31, 30, 15, 18, 31, 30, 123, 31 };
		List<Integer> list = Arrays.asList(arr); 
		return list;
	}
	public void printResult(int k) {
	System.out.println("Number of figures which are divided on 3, but not on 5 = " + k);//9,12,18,123
	}
	
}
