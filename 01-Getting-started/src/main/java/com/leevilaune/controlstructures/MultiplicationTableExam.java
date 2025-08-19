package com.leevilaune.controlstructures;

import java.util.Scanner;
import java.util.Random;

public class MultiplicationTableExam {

    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        Random random = new Random();
        int totalCorrect = 0;
        while(true){
            for(int i = 0; i<10;i++){
                if(askQuestion(r,random)){
                    System.out.println("Correct");
                    totalCorrect++;
                }else{
                    System.out.println("Incorrect");
                }
            }
            System.out.printf("%d/10 Correct",totalCorrect);
            if(totalCorrect == 10){
                System.out.println("\nCongratulations on mastering multiplication!");
                break;
            }
        }
    }

    public static boolean askQuestion(Scanner r, Random random){
        int firstNum = random.nextInt(1,11);
        int secondNum = random.nextInt(1,11);
        System.out.printf("%d * %d = ",firstNum,secondNum);
        int answer = r.nextInt();
        return answer == firstNum * secondNum;
    }
}
