package com.leevilaune.pen;

public class Pen {
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    private Color color;
    private boolean capped;

    public Pen(Color color){
        this.color = color;
        this.capped = true;
    }
    public Pen(){
        this.color = Color.RED;
        this.capped = true;
    }

    public String draw(){
        if(this.capped){
            System.out.println();
            return "";
        }else{
            System.out.println("Drawing " + this.color.toString());
            return "Drawing " + this.color.toString();
        }
    }

    public void capOff(){
        this.capped = false;
    }

    public void capOn(){
        this.capped = true;
    }

    public void changeColor(Color color){
        if(!this.capped){
            return;
        }
        this.color = color;
    }
}