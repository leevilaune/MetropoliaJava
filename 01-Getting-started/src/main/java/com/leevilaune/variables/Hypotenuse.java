package com.leevilaune.variables;

import java.util.Scanner;
//1.2.2
public class Hypotenuse {

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        System.out.print("Give a: ");
        float a = r.nextFloat();
        System.out.print("Give b: ");
        float b = r.nextFloat();
        System.out.println("Hypotenuse is "+pythagoranTheorem(a,b));
    }

    public static float pythagoranTheorem(float a, float b){
        return (float) Math.sqrt(a*a+b*b);
    }
}
