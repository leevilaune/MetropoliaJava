package com.leevilaune.classes;

public class CoffeeMaker {

    private int amountMl;
    private String coffeeType;
    private boolean isOn;

    public CoffeeMaker(){
        this.isOn = false;
    }

    public int getAmountMl() {
        return amountMl;
    }

    public void setAmountMl(int amountMl) {
        if(!this.isOn()){
            return;
        }
        if(amountMl < 10){
            this.amountMl=10;
        } else if (amountMl > 80) {
            this.amountMl=80;
        }
    }

    public String getCoffeeType(String coffeeType){
        return this.coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        if(!this.isOn()){
            return;
        }
        if(!coffeeType.equalsIgnoreCase("espresso")){
            this.coffeeType = "normal";
            return;
        }
        this.coffeeType = coffeeType;
    }

    public void pressOnOff(){
        this.isOn = !this.isOn();
    }
    public boolean isOn(){
        return this.isOn;
    }
}
