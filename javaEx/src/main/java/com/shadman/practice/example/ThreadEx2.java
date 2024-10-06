package com.shadman.practice.example;

public class ThreadEx2 {
    static final Object resourceA = new Object();
    static final Object resourceB = new Object();

    // Given two processes and two resources, make the two processes stuck in deadlock situation
    // when run concurrently
    public static void main(String[] args) throws InterruptedException {
        Thread processA = new Thread(() -> {
            System.out.println("start executing Process A");

            System.out.println("complete executing Process A");
        });

        Thread processB = new Thread(() -> {
            System.out.println("start executing Process B");

            System.out.println("complete executing Process B");
        });
        processA.start();
        processB.start();
        processB.join();
        processA.join();
        System.out.println("Ended");
    }
}
