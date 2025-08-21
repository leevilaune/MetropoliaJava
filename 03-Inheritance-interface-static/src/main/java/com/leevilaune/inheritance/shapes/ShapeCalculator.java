package com.leevilaune.inheritance.shapes;

public class ShapeCalculator {

    public ShapeCalculator(){

    }

    public static void main(String[] args){
        Shape circle = new Circle("red",5);
        Shape rectangle = new Rectangle("black",4,6);
        Shape triangle = new Triangle("green",3,8);

        System.out.println("Shape Calculator");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(triangle);
    }
}
