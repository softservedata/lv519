//Given a natural number n. Is it possible to represent it as the sum of squares of two natural numbers?
//a) If it possible - specify a pair of natural numbers x, y, such that n=x^2 + y^2;
//b) If it possible - specify a pair of natural numbers x, y, such that n=x^2 + y^2 and x>=y;
package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

public class Task243 {
	public List<PairValue_DTO> generateListA(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		List<PairValue_DTO> pairValue = new ArrayList<PairValue_DTO>();
		for (int i = 1; i * i < n; i++) {
			double j = Math.sqrt(n - i * i);
			if ((j == Math.round(j))) {
				PairValue_DTO pair = new PairValue_DTO(i, (int) j);
				pairValue.add(pair);
			}
		}
		return pairValue;

	}

	public List<PairValue_DTO> generateListB(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		List<PairValue_DTO> pairValue = new ArrayList<PairValue_DTO>();
		for (int i = 1; i * i < n; i++) {
			double j = Math.sqrt(n - i * i);
			if ((j == Math.round(j)) && (i >= j)) {
				PairValue_DTO pair = new PairValue_DTO(i, (int) j);
				pairValue.add(pair);
			}
		}
		return pairValue;
	}

	public List<PairValue_DTO> SumSquaresList1(InputOutput inp) {
		return generateListA(inp.getN());
	}

	public List<PairValue_DTO> SumSquaresList2(InputOutput inp) {
		return generateListB(inp.getN());
	}
}
