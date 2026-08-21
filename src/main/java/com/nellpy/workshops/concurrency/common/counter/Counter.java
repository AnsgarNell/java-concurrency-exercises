package com.nellpy.workshops.concurrency.common.counter;

public interface Counter {

    void increment();

    void decrement();

    int value();

}
