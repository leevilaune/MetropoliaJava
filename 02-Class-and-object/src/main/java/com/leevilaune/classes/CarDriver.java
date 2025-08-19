package com.leevilaune.classes;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();
/*
        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
 */
        cruiseControl(myCar);
    }
    public static void cruiseControl(Car car){
        System.out.println("Initial speed: " + car.getSpeed());
        System.out.println("Cruise control is on: " + car.isCruiseControlOn());
        System.out.println("Switching cruise control to 60 → result: " + car.switchCruiseControl(60));
        System.out.println("Cruise control is on: " + car.isCruiseControlOn());
        System.out.println("Speed after switching cruise control: " + car.getSpeed());
        car.setTargetSpeed(100);
        System.out.println("Speed after setting target speed to 100: " + car.getSpeed());
        System.out.println("Switching cruise control to 140 → result: " + car.switchCruiseControl(140));
        System.out.println("Cruise control is on: " + car.isCruiseControlOn());
    }
}