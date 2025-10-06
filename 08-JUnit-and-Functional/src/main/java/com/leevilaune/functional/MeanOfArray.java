package com.leevilaune.functional;

import java.util.ArrayList;
import java.util.Arrays;

public class MeanOfArray {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(MeanOfArray.mean(numbers));
    }

    public static double mean(int[] numbers){
        double mean = Arrays.stream(numbers)
                .reduce(0, Integer::sum) / (double) numbers.length;
        return mean;
    }
}
