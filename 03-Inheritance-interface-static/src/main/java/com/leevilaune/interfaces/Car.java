package com.leevilaune.interfaces;

public class Car extends AbstractVehicle{

    private String type;
    private String fuelType;
    private String color;

    public Car(String type,String fuelType, String color){
        this.type = type;
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public double calculateFuelEfficiency() {
        super.fuelEffieciency = 5;
        return super.fuelEffieciency;
    }

    @Override
    public void start() {
        System.out.println(this.type+" is starting...");
    }

    @Override
    public void stop() {
        System.out.println(this.type+" is stopping...");

    }

    @Override
    public String getInfo() {
        return "Type: " + type + "\n" +
                "Fuel: " + fuelType + "\n" +
                "Color: " + color;
    }

    @Override
    public void charge() {
        System.out.println("No possible to charge.");
    }
}
