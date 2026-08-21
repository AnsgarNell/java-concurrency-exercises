package com.nellpy.workshops.concurrency.common.threads;


public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a runnable thread!");
    }

}
