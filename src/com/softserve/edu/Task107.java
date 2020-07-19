//An integer number n is given, n>1.Get the largest integer k, at which 4 ^ k <n.
package com.softserve.edu;

public class Task107 {
	public int findNumber(int n) {
		if (n < 2) {
			throw new IllegalArgumentException();
		}
		// result=4^k
		// k=power
		int k, p;
		k = 0;
		p = 1;
		while (p < n) {
			p = p * 4;
			k++;
		}
		return k - 1;
	}

	public int findK(InputOutput inp) {
		return findNumber(inp.getN());
	}
}
