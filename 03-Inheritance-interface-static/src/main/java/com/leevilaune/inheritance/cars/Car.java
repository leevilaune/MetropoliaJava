package com.leevilaune.inheritance.cars;

/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */

/*what gasoline consumption? there was no task telling to implement it
and none was implemented in the given class
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    protected double speed;
    protected double gasolineLevel;
    protected double gasolineConsumption;
    protected String typeName;
    private double targetSpeed;
    private boolean cruiseControlOn;
    private double minCruiseSpeed;
    private double maxCruiseSpeed;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
        this.minCruiseSpeed = 40;
        this.maxCruiseSpeed = 120;
    }

    public Car(double speed, double gasolineLevel, String typeName, double gasolineConsumption){
        this.speed = speed;
        this.gasolineLevel = gasolineLevel;
        this.typeName = typeName;
        this.minCruiseSpeed = 40;
        this.maxCruiseSpeed = 120;
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            this.gasolineLevel -= this.gasolineConsumption;
        }
        else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }

    //cruise control
    public boolean setTargetSpeed(double targetSpeed){
        if(targetSpeed>this.maxCruiseSpeed || targetSpeed<this.minCruiseSpeed){
            return false;
        }
        while(targetSpeed != this.speed){
            if(targetSpeed > this.speed){
                this.accelerate();
            } else if (targetSpeed < this.speed) {
                this.decelerate(10);
            }
        }
        return true;
    }
    public double getTargetSpeed(){
        return this.targetSpeed;
    }
    public boolean switchCruiseControl(double targetSpeed){
        if(this.setTargetSpeed(targetSpeed)){
            this.cruiseControlOn = !this.cruiseControlOn;
            return true;
        }else{
            this.cruiseControlOn = false;
            return false;
        }
    }
    public boolean isCruiseControlOn(){
        return this.cruiseControlOn;
    }
}