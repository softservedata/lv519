package task87;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoNumbers {
	private int n;
	private int m;

	private TwoNumbers(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}

	public static TwoNumbers read() {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		int m = 0;
		while ((n < 1) || (m < 1)) {
			System.out.print("Enter natural numbers n and m = ");
			try {
				n = scanner.nextInt();
				m = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("That's not a pair of natural numbers");
				e.printStackTrace();
			}
		}
		scanner.close();
		return new TwoNumbers(n, m);
	}

	public static void write(int sum) {
		System.out.print("Sum of the last m fingers of number n = ");
		System.out.println(sum);
	}

}
