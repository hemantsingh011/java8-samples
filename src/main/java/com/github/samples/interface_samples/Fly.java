package com.github.samples.interface_samples;

public interface Fly {
    default void takeOff() {System.out.println("takeOFF");}

    default void turn() {System.out.println("turn");}

    default void cruise() {System.out.println("cruise");}

    default void land() {
        System.out.println("land");
        //getState();
    }
    // int getState();
}

interface FastFly extends Fly {
    //2. you can override the method
    default void takeOff() {System.out.println("FastFly takeOff");}
}

class Seaplane extends Vehicle implements FastFly {
    //3. If a method is there in the class hierarchy the ut takes precedence

}

class Vehicle {
    //3. If a method is there in the class hierarchy the ut takes precedence
    public void land() {
        System.out.println("Vehicle land");
    }
}

class Sample {
    public void use() {
        Seaplane seaplane = new Seaplane();
        seaplane.takeOff();
        //1. you can access the interface default methods
        seaplane.turn();
        seaplane.cruise();
        seaplane.land();
    }

    public static void main(String[] args) {
        new Sample().use();
    }
}
