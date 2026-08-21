package com.nellpy.workshops.concurrency.exercises.sync.exercise1;

// Based on https://docs.oracle.com/javase/tutorial/essential/concurrency/examples/Counter.java

import com.nellpy.workshops.concurrency.common.counter.Counter;


class ThreadUnsafeCounter implements Counter {

    private int counter = 0;


    @Override
    public void increment() {
        counter++;
    }


    @Override
    public void decrement() {
        counter--;
    }


    @Override
    public int value() {
        return counter;
    }

}
