package com.softserve.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.softserve.edu.Calc;

/**
 * 
 * @author Lv-519.Taqc.Java
 *
 */
public class Maximum {
    Calc calc;
	// protected int j = 11;
	private int j = 11;

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = 1, y = 1; // ???
		try {
			System.out.print("x=");
			x = Integer.parseInt(br.readLine()); // =Float.parseFloat(…);
			System.out.print("y=");
			y = Integer.parseInt(br.readLine());
		} catch (Exception e) { // NumberFormatException
			System.out.println("I/O Error.");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (x > y) {
			System.out.println("x is maximum, x=" + x);
		} else {
			System.out.println("y is maximum, y=" + y);
		}
	}
}