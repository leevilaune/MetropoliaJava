package com.leevilaune.threads;

import java.awt.event.WindowStateListener;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class ParallelNumberSummation {

    public static int[] createRnadomArray(int size){
        Random r = new Random();
        int[] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = r.nextInt(0,10);
        }
        return arr;
    }
    //shit breaks if modulo isnt 0
    public static int[][] splitArrays(int[] array, int partsAmount){
        if(array.length%partsAmount!=0){
            return new int[0][0];
        }
        int[][] splitArray = new int[partsAmount][array.length/partsAmount];
        int totIndex = 0;
        for(int i = 0;i<partsAmount;i++){
            for (int j = 0; j<array.length/partsAmount; j++){
                splitArray[i][j] = array[totIndex];
                totIndex++;
            }
        }
        return splitArray;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();

        int size = 1000;
        int parts = Runtime.getRuntime().availableProcessors();
        //check that available cores is dividable with size, things break otherwise
        //and i cant be bothered to figure it out
        for(int i = parts; i>=1;i--){
            if(i%parts==0){
                break;
            }
            parts = i;
        }
        int [] arr = createRnadomArray(size);
        int[][] intArr = splitArrays(arr,parts);
        if(intArr.length == 0){
            System.out.println("you fucking idiot, array size and split amnt needs to be divisible");
        }
        start = System.nanoTime();
        System.out.println(sumWithoutThreads(arr));
        System.out.println((System.nanoTime() - start) + " ns");

        start = System.nanoTime();
        System.out.println(sumWithThreads(intArr, parts));
        System.out.println((System.nanoTime() - start) + " ns");
    }

    public static int sumWithoutThreads(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum+=i;
        }
        return sum;
    }

    public static int sumWithThreads(int[][] arr, int parts){
        SumThread[] threads = new SumThread[parts];
        for(int i = 0; i<parts;i++){
            SumThread thread = new SumThread(arr[i]);
            threads[i] = thread;
            thread.start();
        }
        try{
            for(SumThread st : threads){
                st.join();
            }
            int sum = 0;
            for(SumThread st : threads){
                sum += st.getSum();
            }
            return sum;
        }catch (InterruptedException ie){
            System.out.println(ie.getCause().toString());
        }
        return 0;
    }
    //from chatgpt, just for testing
    public static boolean splitMatches(int[][] split, int[] original){
        int totalLength = 0;
        for (int[] part : split) {
            totalLength += part.length;
        }

        if (totalLength != original.length) {
            return false;
        }

        int[] flattened = new int[totalLength];
        int index = 0;
        for (int[] part : split) {
            for (int num : part) {
                flattened[index] = num;
                index++;
            }
        }
        return Arrays.equals(original, flattened);
    }
}
