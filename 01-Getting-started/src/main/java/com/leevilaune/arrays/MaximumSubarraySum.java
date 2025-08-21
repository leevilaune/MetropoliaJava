package com.leevilaune.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        System.out.println("How big array? ");
        int size = r.nextInt();
        int[] array = new int[size];
        for(int i = 0; i<size;i++){
            System.out.printf("Give integer %d:",i+1);
            array[i]=r.nextInt();
        }
        //int[] array = {-2, 1, -3, 4, -1, 2, 1, -5};
        findMaxSubarray(array);
    }

    public static void findMaxSubarray(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < array.length; j++) {
                currentSum += array[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = i;
                    startIndex = i+1;
                    end = j;
                    endIndex = j+1;
                }
            }
        }
        int[] result = new int[end - start + 1];
        for (int k = 0; k < result.length; k++) {
            result[k] = array[start + k];
        }
        int sum = Arrays.stream(result).sum();
        System.out.printf("Maximum sum: %d\nIntegers %d-%d",sum,startIndex,endIndex);
    }
}