package com.nellpy.workshops.concurrency.exercises.semaphores.exercise1.solution;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class SiblingSolution implements Runnable {

    private final Semaphore controllers;


    public SiblingSolution(Semaphore controllers) {
        this.controllers = controllers;
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
        if(controllers.tryAcquire(getDuration(), TimeUnit.SECONDS)) {
            try {
                playPs4();
            } finally {
                controllers.release();
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
