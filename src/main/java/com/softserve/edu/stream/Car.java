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
    }
}
