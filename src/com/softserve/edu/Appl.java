package com.softserve.edu;

import java.util.Scanner;

public class Appl {
    /*-
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = scanner.nextInt();
        System.out.print("b = ");
        b = scanner.nextInt();
        res = a+b;
        System.out.println("res = " + res);
    }
    */
    
    public static void main(String[] args) {
        Sum sum = new Sum();
        Two two = Two.read();
        Two.write(sum.add(two));
    }
}
