
package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a natural number n. Is it possible to represent it as the sum of
 * squares of two natural numbers? <br>
 * a) If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2; <br>
 * b) If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2 and x>=y.
 * 
 * @author Iryna Polihas
 *
 */
public class Task243 {
	/**
	 * @param n natural number
	 * @return list of numbers x, y, such that n=x^2+y^2
	 */
	public List<PairNaturalNumbers_DTO> calculateListOfNumber(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		List<PairNaturalNumbers_DTO> pairNumbers = new ArrayList<PairNaturalNumbers_DTO>();
		for (int i = 1; i * i < n; i++) {
			double j = Math.sqrt(n - i * i);
			if ((j == Math.round(j))) {
				PairNaturalNumbers_DTO pair = new PairNaturalNumbers_DTO(i, (int) j);
				pairNumbers.add(pair);
			}
		}
		return pairNumbers;
	}

	/**
	 * @param n natural number
	 * @return list of numbers x, y, such that n=x^2+y^2 and x>=y
	 */
	public List<PairNaturalNumbers_DTO> calculateListOfSpecNumbers(int n) {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		List<PairNaturalNumbers_DTO> pairNumbers = new ArrayList<PairNaturalNumbers_DTO>();
		for (int i = 1; i * i < n; i++) {
			double j = Math.sqrt(n - i * i);
			if ((j == Math.round(j)) && (i >= j)) {
				PairNaturalNumbers_DTO pair = new PairNaturalNumbers_DTO(i, (int) j);
				pairNumbers.add(pair);
			}
		}
		return pairNumbers;
	}

	public List<PairNaturalNumbers_DTO> ListOfSumSquares(InputOutput inp) {
		return calculateListOfNumber(inp.getN());
	}

	public List<PairNaturalNumbers_DTO> ListOfSpecSumSquares(InputOutput inp) {
		return calculateListOfSpecNumbers(inp.getN());
	}
}
