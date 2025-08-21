package com.leevilaune.inheritance.cars;

public class Bus extends Car{

    private int passengers;

    public Bus(String typeName,int passengers) {
        super(typeName);
        this.passengers = passengers;
    }

    public Bus(double speed, double gasolineLevel, String typeName, int passengers, double gasolineConsumption) {
        super(speed, gasolineLevel, typeName,gasolineConsumption);
        this.passengers = passengers;
    }

    public void passengerEnter(){
        this.passengers++;
    }
    public void passengerExit(){
        this.passengers--;
    }
}
