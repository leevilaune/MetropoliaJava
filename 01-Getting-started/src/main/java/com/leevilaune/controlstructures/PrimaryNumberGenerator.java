package com.leevilaune.controlstructures;

import java.util.Scanner;

public class PrimaryNumberGenerator {

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        while(true){
            System.out.println("Start: ");
            int start = r.nextInt();
            System.out.println("End: ");
            int end = r.nextInt();
            if((start < 0 || end < 0) || start > end){
                continue;
            }
            else {
                for(int i = start; i<end; i++){
                    if(isPrime(i)){
                        System.out.println(i);
                    }
                }
                break;
            }
        }

    }
    public static boolean isPrime(int number){
        for(int i = 2;i<=number/2;i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
