package task555;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OneNumber {

	private int n;

	public OneNumber(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public static OneNumber read() {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		while (n < 1) {
			System.out.print("Enter natural number n = ");
			try {
				n = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("That's not a natural numbers");
				e.printStackTrace();
			}
		}
		scanner.close();
		return new OneNumber(n);
	}

	public static void write(int[][] a) {
		System.out.println("Pascal matrix, dimension n");

		for (int[] row : a) {
			for (int node : row) {
				System.out.print(node + " ");
			}
			System.out.println();
		}

	}

}
