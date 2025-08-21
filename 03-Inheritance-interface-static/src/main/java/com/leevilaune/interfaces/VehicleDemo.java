package com.leevilaune.interfaces;

public class VehicleDemo {

    public static void main(String[] args){
        AbstractVehicle car = new Car("Car","Petrol","Red");
        AbstractVehicle motorcycle = new Motorcycle("Motorcycle","Gasoline","Black");
        AbstractVehicle bus = new Bus("Bus","Diesel",40);
        AbstractVehicle electricCar = new ElectricCar("Electric Car", "Electric", "White");

        car.start();
        car.stop();
        System.out.println(car.getInfo());
        car.charge();

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());
        motorcycle.charge();

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
        bus.charge();

        electricCar.start();
        electricCar.stop();
        System.out.println(electricCar.getInfo());
        electricCar.charge();
    }
}
