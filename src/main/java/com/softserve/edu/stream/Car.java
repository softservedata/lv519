package com.softserve.edu.stream;

interface Vehicle {
    //void print();
    
    default void print() {
        System.out.println("I am a vehicle!");
        //blowHorn(); // Ok
    }
    
    static void blowHorn() {
        System.out.println("Blowing horn!!!");
        //print(); // Error
     }

}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

public class Car implements Vehicle, FourWheeler {

//    public void print() {
//        System.out.println("Custom method!");
//    }

    public void print() {
        Vehicle.super.print();
        //FourWheeler.super.print();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.print();
        // car.blowHorn(); // Error
        // Car.blowHorn(); // Error
        Vehicle.blowHorn();
        /*-
        Car c1 = new Car();
        Car c2 = new Car();
        System.out.println("c1 = " + c1.hashCode());
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2.hashCode());
        Integer ii;
        Float ff;
        Double dd = 12.1;
        Long ll;
        */
    }
}
