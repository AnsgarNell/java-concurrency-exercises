package com.nellpy.workshops.concurrency.exercises.threads.virtual.exercise2;


public class Exercise2HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from callable thread " + Thread.currentThread().threadId() + "!");
    }

}
