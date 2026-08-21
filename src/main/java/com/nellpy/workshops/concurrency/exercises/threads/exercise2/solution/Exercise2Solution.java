package com.nellpy.workshops.concurrency.exercises.threads.exercise2.solution;


public class Exercise2Solution {

    static void main() throws InterruptedException {
        Thread thread1 = new Exercise2HelloThreadSolution();
        Thread thread2 = new Exercise2HelloThreadSolution();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
