package com.nellpy.workshops.concurrency.common.threads;


import java.time.LocalDateTime;


public class TimeLoggingHelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("[" + LocalDateTime.now() + "] Hello from a runnable thread!");
    }

}
