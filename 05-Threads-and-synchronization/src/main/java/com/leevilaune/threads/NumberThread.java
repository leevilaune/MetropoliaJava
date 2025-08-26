package com.leevilaune.threads;

public class NumberThread extends Thread{

    private boolean isEven;
    private double delay;
    private double delayOffset;
    private int startNum;
    private boolean finished;

    public NumberThread(boolean isEven, double delay, double delayOffset){
        this.isEven = isEven;
        this.delay = delay;
        this.delayOffset = delayOffset;
        this.startNum = 0;
        if(!isEven){
            this.startNum=1;
        }
        this.finished = false;
    }

    @Override
    public void run() {
        for(int i = this.startNum; i<=20;i+=2){
            System.out.println((isEven ? "Even Thread" : "Odd Thread") + " -> " + i);
            try {
                Thread.sleep((long) (this.delay*1000L+this.delayOffset* 1000L));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println((isEven ? "Even Thread" : "Odd Thread") + " -> done");
        this.finished=true;
    }                                      

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public double getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public double getDelayOffset() {
        return delayOffset;
    }

    public void setDelayOffset(int delayOffset) {
        this.delayOffset = delayOffset;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public void setFinished(boolean hasFinished) {
        this.finished = hasFinished;
    }

    public static void main(String[] args){
        NumberThread even = new NumberThread(true,1,0);
        NumberThread odd = new NumberThread(false,1,0.5);
        even.start();
        odd.start();

        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Printing complete");
    }
}