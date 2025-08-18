package com.leevilaune.arrays;

import java.util.Random;
import java.util.Scanner;

public class RandomNameGenerator {

    public static void main(String[] args){
        String[] firstNames = {
                "Alice", "Bob", "Charlie", "Diana", "Ethan",
                "Fiona", "George", "Hannah", "Isaac", "Julia"
        };
        String[] lastNames = {
                "Smith", "Johnson", "Williams", "Brown", "Jones",
                "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"
        };
        Scanner r = new Scanner(System.in);
        Random random = new Random();
        System.out.println("How many names to generate? ");
        int amount = r.nextInt();
        for(int i = 0;i<amount;i++){
            System.out.println(
                    firstNames[random.nextInt(0,firstNames.length)]+" "+
                    lastNames[random.nextInt(0,lastNames.length)]);
        }
    }
}
