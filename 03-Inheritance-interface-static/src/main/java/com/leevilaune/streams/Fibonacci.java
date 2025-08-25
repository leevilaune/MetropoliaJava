package com.leevilaune.streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci {

    public static void main(String[] args){
        File f = new File("fibonacci.csv");
        System.out.println(f.getAbsolutePath());
        try {
            FileWriter writer = new FileWriter(f);
            long firstNum = 0;
            writer.append(String.valueOf(firstNum)).append("\n");
            long secondNum = 1;
            writer.append(String.valueOf(secondNum)).append("\n");
            for(int i = 0;i <58;i++){
                long newNum = firstNum+secondNum;
                firstNum = secondNum;
                secondNum = newNum;
                writer.append(String.valueOf(newNum)).append("\n");
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
