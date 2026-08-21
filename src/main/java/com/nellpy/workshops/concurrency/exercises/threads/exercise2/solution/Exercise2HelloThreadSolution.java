package com.nellpy.workshops.concurrency.exercises.threads.exercise2.solution;

public class Exercise2HelloThreadSolution extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from thread " + Thread.currentThread().getName() + "!");
    }

}
