package com.nellpy.workshops.concurrency.exercises.threads.virtual.exercise2.solution;


public class Exercise2HelloRunnableSolution implements Runnable {

    @Override
    public void run() {
        String message =
                "Hello from runnable thread " + Thread.currentThread().threadId() + "! I am a " +
                        (Thread.currentThread().isVirtual() ? "virtual" : "platform")
                        + " thread.";
        System.out.println(message);
    }

}
