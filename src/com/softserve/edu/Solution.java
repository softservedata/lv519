package com.softserve.edu;

public class Solution {
	public static void main(String[] args) {
		InputOutput inp = InputOutput.readNatural();
		// 107
		//Task107 num1 = new Task107();
		//InputOutput.writeNumber(num1.findK(inp));
		// 108
		Task108 num2 = new Task108();
		InputOutput.writeArray(num2.findR(inp));
		// 243
		Task243 pair = new Task243();
		// a
		InputOutput.writeObjectList(pair.SumSquaresList1(inp));
		// b
		InputOutput.writeObjectList(pair.SumSquaresList2(inp));
	}
}
