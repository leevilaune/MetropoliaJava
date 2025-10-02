package com.leevilaune.collectionoper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));
        System.out.println("Initial list");
        ints.removeIf(i -> i%2==0);
        System.out.println("Filtered even numbers");
        ints.forEach(System.out::println);
        ints.replaceAll(i -> i*2);
        System.out.println("Doubled odd numbers");
        ints.forEach(System.out::println);
        int[] sum = new int[1];
        ints.forEach(i->sum[0]+=i);
        System.out.println("Sum of doubled odd numbers: "+sum[0]);
    }
}
