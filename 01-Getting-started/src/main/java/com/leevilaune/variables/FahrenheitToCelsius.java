package com.leevilaune.variables;

import java.util.Scanner;
//1.2.1
public class FahrenheitToCelsius {

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        System.out.print("Give fahrenheit degrees: ");
        int fahrenheit = Integer.parseInt(r.nextLine());
        System.out.printf("%d Fahrenheit is%6.1f %s",fahrenheit,fahrenheitToCelsius(fahrenheit),"celsius");
    }

    public static double fahrenheitToCelsius(int fahrenheit){
        return (fahrenheit-32)*((double)5/9);
    }
}
