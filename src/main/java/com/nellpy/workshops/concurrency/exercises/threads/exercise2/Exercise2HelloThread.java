package com.nellpy.workshops.concurrency.exercises.threads.exercise2;

public class Exercise2HelloThread extends Thread {

    @Override
    public void run() {
        // TODO: Change the message and print the thread name in order to identify it
        System.out.println("Hello from a thread!");
    }

}
