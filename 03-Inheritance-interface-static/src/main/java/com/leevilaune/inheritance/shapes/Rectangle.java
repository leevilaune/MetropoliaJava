package com.leevilaune.inheritance.shapes;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(String color,double width,double height){
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return width*height;
    }

    @Override
    public String toString(){
        return "Area of Rectangle with width " + this.width + " and height: "+ this.height +": " + calculateArea()
                + "\nColor of Rectangle is: " + super.color;
    }
}
