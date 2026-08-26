package com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.solution;

import com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.ForkPair;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class PhilosopherSolution implements Runnable {

    protected static final String LEFT = "left";

    protected static final String RIGHT = "right";

    protected final Object firstFork;

    protected final Object secondFork;


    public PhilosopherSolution(ForkPair forkPair) {
        this.firstFork = forkPair.firstFork();
        this.secondFork = forkPair.secondFork();
    }


    protected PhilosopherSolution(Object firstFork, Object secondFork) {
        this.firstFork = firstFork;
        this.secondFork = secondFork;
    }


    protected String getFirstForkName() {
        return LEFT;
    }


    protected String getSecondForkName() {
        return RIGHT;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            eat();
            think();
        }
    }


    private void eat() {
        synchronized(firstFork) {
            printMessage(getFirstForkName() + " fork picked up");
            processOtherFork();
        }
    }


    private void processOtherFork() {
        printMessage("trying to pick up " + getSecondForkName() + " fork");
        synchronized(secondFork) {
            printMessage("eating");
            delay();
        }
    }


    private void think() {
        printMessage("thinking");
        delay();
    }


    private void delay() {
        try {
            int timeOut = ThreadLocalRandom.current().nextInt(100);
            TimeUnit.MILLISECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void printMessage(String message) {
        System.out.println(Thread.currentThread().getName() + " " + message);
    }

}
