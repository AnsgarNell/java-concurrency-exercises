package com.nellpy.workshops.concurrency.exercises.threads.exercise2;

public class Exercise2 {

    static void main() throws InterruptedException {
        Thread thread1 = new Exercise2HelloThread();
        Thread thread2 = new Exercise2HelloThread();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
