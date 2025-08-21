package com.leevilaune.inheritance.cars;

public class SportsCar extends Car{

    public SportsCar(String typeName) {
        super(typeName);
    }

    public SportsCar(double speed, double gasolineLevel, String typeName, double gasolineConsumption) {
        super(speed, gasolineLevel, typeName, gasolineConsumption);
    }
    @Override
    public void accelerate() {
        if (super.gasolineLevel > 0)
            super.speed += 20;
        else
            super.speed = 0;
    }
}
