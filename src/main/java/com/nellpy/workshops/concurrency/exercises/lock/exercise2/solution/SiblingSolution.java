package com.nellpy.workshops.concurrency.exercises.lock.exercise2.solution;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


public class SiblingSolution implements Runnable {

    private final Lock controller1;

    private final Lock controller2;


    public SiblingSolution(Lock controller1, Lock controller2) {
        this.controller1 = controller1;
        this.controller2 = controller2;
    }


    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while(true) {
            try {
                startToPlay();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void startToPlay() throws InterruptedException {
        if(controller1.tryLock(getDuration(), TimeUnit.SECONDS)) {
            try {
                playPs4();
            } finally {
                controller1.unlock();
            }
            goToTheCouch();
        } else if(controller2.tryLock(getDuration(), TimeUnit.SECONDS)) {
            try {
                playPs4();
            } finally {
                controller2.unlock();
            }
            goToTheCouch();
        } else {
            printMessage("Can I play with the PS4? NO!");
        }
    }


    private void playPs4() {
        try {
            printMessage("playing PS4");
            TimeUnit.SECONDS.sleep(getDuration());
            printMessage("finished playing PS4");
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    private void goToTheCouch() {
        try {
            TimeUnit.SECONDS.sleep(getDuration());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    private void printMessage(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + Thread.currentThread().getName() + " " + message);
    }


    private int getDuration() {
        return ThreadLocalRandom.current().nextInt(5, 10);
    }
}
