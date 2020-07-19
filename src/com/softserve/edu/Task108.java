//An integer number n is given. Get the smallest number 2^r, which exceeds n, (2 ^ r> n).
package com.softserve.edu;

public class Task108 {
	public int[] findArr(Integer n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		// result=4^k
		// k=power
		int result, power;
		power = 0;
		result = 1;
		int arr[] = new int[2];
		while (result <= n) {
			result = result * 2;
			power++;
			arr[0] = result;
			arr[1] = power;
		}
		return arr;
	}

	public int[] findR(InputOutput inp) {
		return findArr(inp.getN());
	}

}
