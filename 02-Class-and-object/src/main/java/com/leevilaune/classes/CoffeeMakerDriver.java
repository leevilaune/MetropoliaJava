package com.leevilaune.classes;

public class CoffeeMakerDriver {

    public static void main(String[] args){
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is on");
        coffeeMaker.setCoffeeType("espresso");
        System.out.println("Coffee type is " + coffeeMaker.getCoffeeType());
        coffeeMaker.setAmountMl(50);
        System.out.println("Coffee amount is "+coffeeMaker.getAmountMl()+" ml");
        coffeeMaker.pressOnOff();
        System.out.println("Coffee maker is off");
    }
}