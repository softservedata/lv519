package com.softserve.edu;

import java.util.Scanner;

public class Two { //extends FileData //extends ConsoleData {
    private double a;
    private double b;

    public Two(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public static Two read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        scanner.close();
        return new Two(a, b);
    }
    
    public static void write(double res) {
        System.out.println("res = " + res);
    }
    
}
