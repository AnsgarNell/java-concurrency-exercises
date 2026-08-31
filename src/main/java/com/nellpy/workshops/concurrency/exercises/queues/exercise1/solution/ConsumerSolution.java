package com.nellpy.workshops.concurrency.exercises.queues.exercise1.solution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ConsumerSolution implements Runnable {

    private final BlockingQueue<Object> blockingQueue;


    public ConsumerSolution(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Object object = blockingQueue.take();
                consume(object);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
