package com.leevilaune.threads;

public class SumThread extends Thread {

    private int[] arr;
    private int sum;

    public SumThread(int[] arr){
        this.arr = arr;
        this.sum = 0;
    }

    @Override
    public void run() {
        for(int i : this.arr){
            this.sum+=i;
        }
    }

    @Override
    public void start() {
        super.start();
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}

