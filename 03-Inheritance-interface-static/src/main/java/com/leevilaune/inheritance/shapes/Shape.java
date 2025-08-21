package com.leevilaune.inheritance.shapes;

public class Shape {

    protected String color;

    public Shape(String color){
        this.color = color;
    }
    public double calculateArea(){
        return 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                '}';
    }
}
