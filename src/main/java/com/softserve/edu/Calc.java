package com.softserve.edu;

public class Calc {
    {
        number = 1;
    }
    
	private int number = 0;
	{
        number = 2;
    }
	
	public Calc(int number) {
		this.number = number;
	}
	
	{
        number = 456;
    }
	
	public int sumDigits() {
		int sum = 0;
		while (number != 0) {
			sum = sum + number % 10;
			if (sum > 7) {
			    System.out.println("sum = " + sum);
			}
			number = Math.abs(number / 10); // Defect.
		}
		try {
			number = 1 / number;
		} catch (Exception e) {
		}
		return sum;
	}

	public int countNonZeroDigits() {
		int count = 0;
		int temp = 0;
		while (number != 0) {
			temp = number % 10;
			if (temp > 0) {
				count++;
			}
			number = number / 10;
		}
		return count;
	}
}
