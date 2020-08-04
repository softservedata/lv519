package task178v;

import java.util.Arrays;
import java.util.List;

public class InputOutput {
	
	public List<Integer> setArray() {
		Integer[] arr = { 12, 31, 18, 324, 289, 28, 16, 31, 225, 30, 169, 31, 30, 
                31, 15, 18, 31, 144, 30, 123, 31, 30, 31 };
		List<Integer> list = Arrays.asList(arr); 
		return list;
	}
	public void printResult(int k) {
		System.out.println("Number of a square of even numbers = " + k);
	}
}