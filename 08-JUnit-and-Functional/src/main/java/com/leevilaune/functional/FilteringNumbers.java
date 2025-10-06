package com.leevilaune.functional;

import java.util.ArrayList;
import java.util.Arrays;

public class FilteringNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        ));

        System.out.println(sumOfDoubledOddNums(numbers));
    }
    public static double sumOfDoubledOddNums(ArrayList<Integer> numbers){
        return numbers.stream()
                .filter(i -> i%2!=0)
                .map(i -> i*2)
                .reduce(0, Integer::sum);
    }

}
