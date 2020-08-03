package com.softserve.edu;

/**
 * An integer number n is given, n>1. Get the largest integer k, at which 4^k
 * less then n.
 * 
 * @author Iryna Polihas
 */
public class Task107 {
	/**
	 * @param n > 1, integer number
	 * @return max power k, at which 4^k less then n.
	 */
	public int calculateMaxPower(int n) {

		if (n < 2) {
			throw new IllegalArgumentException();
		}
		int k, p;// k-power; p=4^k;
		k = 0;
		p = 1;
		while (p < n) {
			p = p * 4;
			k++;
		}
		return k - 1;
	}

	public int findMaxPower(InputOutput inp) {
		return calculateMaxPower(inp.getN());
	}
}
