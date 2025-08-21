package com.leevilaune.interfaces;

public abstract class AbstractVehicle implements Vehicle,ElectricVehicle{

    protected double fuelEffieciency;

    public abstract double calculateFuelEfficiency();

    public abstract void start();

    public abstract void stop();

    public abstract String getInfo();

}
