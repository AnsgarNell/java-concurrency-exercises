package com.nellpy.workshops.concurrency.exercises.queues.exercise1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class Producer implements Runnable {

    private final BlockingQueue<Object> blockingQueue;


    public Producer(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            Object object = produce();
            // TODO: Add produced object to the queue. Try using add, offer, put and a timed offer. What are the differences in the execution results?
        }
    }


    private Object produce() {
        System.out.println(Thread.currentThread().getName() + " produced an element");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return new Object();
    }

}
