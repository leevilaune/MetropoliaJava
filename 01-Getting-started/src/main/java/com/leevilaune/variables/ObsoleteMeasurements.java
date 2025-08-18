package com.leevilaune.variables;

import java.util.Scanner;

//1.2.3
public class ObsoleteMeasurements {
    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        System.out.print("Weight (g): ");
        float grams = r.nextFloat();
        float inLuotis = gramsToLuoti(grams);
        int inNaulas = (int)inLuotis/32;
        int inLeiviskas = inNaulas/20;
        System.out.printf("%6.0f grams is %d leiviskä, %d naula, and %2.2f luoti.",grams,inLeiviskas,inNaulas-20*inLeiviskas,inLuotis-32*inNaulas);
    }
    public static float gramsToLuoti(float grams){
        return (float) (grams/13.28);
    }
}
