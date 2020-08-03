package com.softserve.edu;

/**
 * <h1>Algorithmic Tasks Solution</h1>
 * <p>
 * <b>107</b>: An integer number n is given, n>1.Get the largest integer k, at
 * which 4^k less then n;
 * </p>
 * 
 * @author Iryna Polihas
 * @version 1.0 27-07-2020
 */
public class Solution_107 {

	public static void main(String[] args) {
		InputOutput inpNumber = InputOutput.readNatural();
		Task107 task1 = new Task107();
		InputOutput.writeNumber(task1.findMaxPower(inpNumber));
	}
}
