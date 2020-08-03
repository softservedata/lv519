package com.softserve.edu;

/**
 * <h1>Algorithmic Tasks Solution</h1>
 * <p>
 * <b>108</b>: An integer number n is given. Get the smallest number 2^r, which
 * exceeds n, (2^r>n);
 * </p>
 * 
 * @author Iryna Polihas
 * @version 1.0 27-07-2020
 */
public class Solution_108 {

	public static void main(String[] args) {
		InputOutput inpNumber = InputOutput.readNatural();
		Task108 task2 = new Task108();
		InputOutput.writeArray(task2.findMinResult(inpNumber));
	}
}
