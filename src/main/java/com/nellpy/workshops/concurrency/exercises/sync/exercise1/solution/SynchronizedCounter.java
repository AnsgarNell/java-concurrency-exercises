package com.nellpy.workshops.concurrency.exercises.sync.exercise1.solution;

import com.nellpy.workshops.concurrency.exercises.sync.exercise1.Counter;


public class SynchronizedCounter implements Counter {

    private int counter = 0;


    @Override
    public synchronized void increment() {
        counter++;
    }


    @Override
    public synchronized void decrement() {
        counter--;
    }


    @Override
    public synchronized int value() {
        return counter;
    }
}
