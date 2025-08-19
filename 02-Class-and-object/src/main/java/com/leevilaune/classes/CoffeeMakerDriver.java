package com.leevilaune.classes;

public class CoffeeMakerDriver {

    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is on");
        coffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type is espresso");
        coffeeMaker.setAmountMl(50);
        System.out.println("Coffee amount is 50 ml");
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is off");
    }
}