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
    //  default void takeOff() {System.out.println("FastFly takeOff");}
}

class Seaplane extends Vehicle implements FastFly {

    //3. If a method is there in the class hierarchy the ut takes precedence

}

//4 When there are 2 same method in the inteface hierarchy then you need to implement the method in the class
// and you can leverage on point 3 to enhance child class behaviour
class Plane implements Fly, Sail {
    @Override
    public void cruise() {
        Fly.super.cruise();
    }
}

interface Sail {
    default void cruise() { System.out.println("Sail cruise");}
}

class Vehicle implements Fly {
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
