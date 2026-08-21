package com.nellpy.workshops.concurrency.common;


public class NamedHelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a runnable thread " + Thread.currentThread() + "!");
    }

}
