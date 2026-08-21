package com.nellpy.workshops.concurrency.exercises.lock.exercise1;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


public class Sibling implements Runnable {

    private final Lock playstationLock;


    public Sibling(Lock playstationLock) {
        this.playstationLock = playstationLock;
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
        if(playstationLock.tryLock(getDuration(), TimeUnit.MILLISECONDS)) {
            try {
                playPs4();
                goToTheCouch();
            } finally {
                playstationLock.unlock();
            }
        }
    }


    private void playPs4() {
        System.out.println("[" + LocalDateTime.now() + "] " + Thread.currentThread().getName() + " playing PS4");
        delayExecution();
    }


    private void goToTheCouch() {
        delayExecution();
    }


    private void delayExecution() {
        try {
            TimeUnit.MILLISECONDS.sleep(getDuration());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


    private int getDuration() {
        return ThreadLocalRandom.current().nextInt(100, 500);
    }
}
