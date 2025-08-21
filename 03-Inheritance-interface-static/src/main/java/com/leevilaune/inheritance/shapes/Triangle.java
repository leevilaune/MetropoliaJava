package com.leevilaune.inheritance.shapes;

public class Triangle extends Shape{

    public double base;
    public double height;

    public Triangle(String color,double base, double height){
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return (base*height)/2;
    }
    @Override
    public String toString(){
        return "Area of Triangle with base " + this.base + " and height: "+ this.height +": " + calculateArea()
                + "\nColor of Triangle is: " + super.color;
    }
}
