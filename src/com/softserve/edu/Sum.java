package com.softserve.edu;

public class Sum { //extends FileData //extends ConsoleData {

    public double add(double arg0, double arg1) {
        return arg0 + arg1;
    }
    
    public double add(Two two) {
        return add(two.getA(), two.getB());
    }
    
}
