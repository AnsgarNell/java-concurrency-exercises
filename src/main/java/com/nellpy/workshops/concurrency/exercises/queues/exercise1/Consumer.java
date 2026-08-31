package com.nellpy.workshops.concurrency.exercises.queues.exercise1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class Consumer implements Runnable {

    private final BlockingQueue<Object> blockingQueue;


    public Consumer(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            // TODO: Retrieve object from the queue. Try using remove, poll, take and a timed poll. What are the differences in the execution results?
            Object object = new Object();
            consume(object);
        }
    }


    private void consume(@SuppressWarnings("unused") Object object) {
        System.out.println(Thread.currentThread().getName() + " consumed an element");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

}
