package com.leevilaune.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadSafeList<T> {
    private final List<T> list = new ArrayList<>();

    public synchronized void add(T element) {
        list.add(element);
    }

    public synchronized boolean remove(T element) {
        return list.remove(element);
    }

    public synchronized int size() {
        return list.size();
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeList<Integer> safeList = new ThreadSafeList<>();
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                safeList.add((int) (Math.random() * 10));
            }
            for (int i = 0; i < 50; i++) {
                safeList.remove(0);
            }
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Final size: " + safeList.size());
    }
}