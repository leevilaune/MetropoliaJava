package com.leevilaune.interfaces;

public class Bus extends AbstractVehicle{
    private String type;
    private String fuelType;
    private int capacity;

    public Bus(String type,String fuelType, int capacity){
        this.type = type;
        this.fuelType = fuelType;
        this.capacity = capacity;
    }

    @Override
    public double calculateFuelEfficiency() {
         super.fuelEffieciency = 15;
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
                "Capacity: " + capacity;
    }

    @Override
    public void charge() {
        System.out.println("No possible to charge.");
    }
}
