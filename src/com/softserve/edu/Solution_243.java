package com.softserve.edu;

/**
 * <h1>Algorithmic Tasks Solution</h1>
 * <p>
 * <b>243</b>: Given a natural number n. Is it possible to represent it as the
 * sum of squares of two natural numbers? <br>
 * <b>a)</b> If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2; <br>
 * <b>b)</b> If it possible - specify a pair of natural numbers x, y, such that
 * n=x^2+y^2 and x>=y.
 * </p>
 * 
 * @author Iryna Polihas
 * @version 1.0 27-07-2020
 */
public class Solution_243 {
	public static void main(String[] args) {
		InputOutput inpNumber = InputOutput.readNatural();
		Task243 task3 = new Task243();
		InputOutput.writeObjectList(task3.ListOfSumSquares(inpNumber));// 243a
		InputOutput.writeObjectList(task3.ListOfSpecSumSquares(inpNumber));// 243b
	}
}
