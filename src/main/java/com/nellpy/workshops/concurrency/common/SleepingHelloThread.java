package com.nellpy.workshops.concurrency.common;

import java.util.concurrent.TimeUnit;


public class SleepingHelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}
