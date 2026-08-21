package com.nellpy.workshops.concurrency.exercises.atomic.exercise1.solution;

import com.nellpy.workshops.concurrency.common.counter.Counter;

import java.util.concurrent.atomic.AtomicInteger;


class AtomicCounter implements Counter {

    private final AtomicInteger counter = new AtomicInteger(0);


    @Override
    public void increment() {
        counter.incrementAndGet();
    }


    @Override
    public void decrement() {
        counter.decrementAndGet();
    }


    @Override
    public int value() {
        return counter.get();
    }

}
