package com.leevilaune.controlstructures;

import java.util.Scanner;

public class BinaryToDecimal {

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        String bin = r.nextLine();
        System.out.printf("0b%s is %d in decimal",bin,binToDec(bin));
    }
    public static int binToDec(String bin){
        int sum = 0;
        for (int i = bin.length(); i > 0; i--) {
            int bit = Integer.parseInt(String.valueOf(bin.charAt(i - 1)));
            int power = bin.length() - i;
            int value = (int) (bit * Math.pow(2, power));
            sum += value;
        }
        return sum;
    }
}
