package com.softserve.edu.collect;

public class Appl {
    public static void main(String[] args) {
        //Box box = new Box();
        //BoxWrapper box = new BoxWrapper();
        BoxGen<Integer> box = new BoxGen<>();
        //
        box.set(123);
        // Code ...
        String text = "124";
        //box.set(text); // Compile Error
        //
        //Integer i = (Integer) box.get(); // Code Smell if Box box = new Box();
        Integer i = box.get();
        //
        System.out.println("i = " + i);
    }
}
