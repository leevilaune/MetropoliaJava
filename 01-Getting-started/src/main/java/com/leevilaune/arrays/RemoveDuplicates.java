package com.leevilaune.arrays;

import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        System.out.print("How big array? ");
        int size = r.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Give integer %d:", i + 1);
            array[i] = r.nextInt();
        }
        System.out.println("The array without duplicates:");
        for(int i : removeDuplicates(array)){
            System.out.print(i+" ");
        }
        //int[] array = {-2, 1, -3, 4, -1, 2, 1, -5};
    }
    public static int[] removeDuplicates(int[] array){
        int[] uniques = new int[array.length];
        int nextIndex = 0;
        for(int i : array){
            if(!arrayContains(uniques,i)){
                uniques[nextIndex] = i;
                nextIndex++;
            }
        }
        int[] uniqueEntries = new int[nextIndex];
        int index = 0;
        for(int i : uniques){
            if(index==nextIndex){
                break;
            }
            uniqueEntries[index] = i;
            index++;
        }
        return uniqueEntries;
    }
    public static boolean arrayContains(int[] array, int num){
        for(int i : array){
            if (i==num){
                return true;
            }
        }
        return false;
    }
}
