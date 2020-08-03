package com.softserve.edu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
	private int n;

	public InputOutput(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	/**
	 * @return natural namber from console
	 */
	public static InputOutput readNatural() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a natural  number n = ");
		int num = 1;
		boolean b = true;
		while (b) {
			try {
				num = scanner.nextInt();
				if (num >= 1) {
					b = false;
					return new InputOutput(num);
				} else {
					System.out.println("Please enter n>=1");
				}
			} catch (InputMismatchException a) {
				System.out.println("That is not an integer number. Try again.");
				scanner.nextLine();
			}
		}
		scanner.close();
		return null;

	}

	/**
	 * @param num - integer number
	 */
	public static void writeNumber(int num) {
		System.out.println("Task-107: 4^k<n, n>1,\nk = " + num);
	}

	/**
	 * @param arr - array of integer number
	 */
	public static void writeArray(int[] arr) {
		System.out.println("Task-108: 2^k>n, n>=1\nk=" + arr[0] + ", 2^k=" + arr[1]);
	}

	/**
	 * @param list - list of objects
	 */
	public static void writeObjectList(List<PairNaturalNumbers_DTO> list) {
		if (list.isEmpty()) {
			System.out.println("Task-243: There is no pair of natural numbers x, y, such that n=x^2+y^2");
		} else {
			System.out.println("Task-243: x^2+y^2=n ");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("x = " + list.get(i).getX() + ", y = " + list.get(i).getY());
			}
		}
	}
}
