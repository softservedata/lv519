package com.softserve.edu;

public class ApplCalc {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("4+4= " + calc.add(4, 4));
        System.out.println("40/4= " + calc.div(40, 4));
    }

}
