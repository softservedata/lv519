package com.softserve.edu;

/**
 * An integer number n is given. Get the smallest number 2^k, which exceeds n,
 * (2 ^ k> n).
 * 
 * @author Iryna Polihas
 */
public class Task108 {
	/**
	 * @param n > 0, integer number
	 * @retur array of power k and smallest number 2^k, which exceeds n
	 */
	public int[] calculateMinResult(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		int k, p;// k-power; p=2^k;
		k = 0;
		p = 1;
		int arr[] = new int[2];
		while (p <= n) {
			p = p * 2;
			k++;
			arr[0] = k;
			arr[1] = p;
		}
		return arr;
	}

	public int[] findMinResult(InputOutput inp) {
		return calculateMinResult(inp.getN());
	}

}
