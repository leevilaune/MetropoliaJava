package com.leevilaune.controlstructures;

public class QuadraticEquation {

    public static void main(String[] args){
        System.out.println(solveQuadraticEquation(2,-3,-2));

    }
    public static String solveQuadraticEquation(int a,int b, int c){
        float root1 = (float) ((-b + Math.sqrt(b*b - 4*a*c)) / (2*a));
        float root2 = (float) ((-b - Math.sqrt(b*b - 4*a*c)) / (2*a));
        if(Float.isNaN(root1) && Float.isNaN(root2)){
            return "No real roots";
        }
        return "Root 1: " + root1 + "\nRoot 2: " + root2;

    }
}
