package com.nellpy.workshops.concurrency.exercises.queues.exercise1.solution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class ProducerSolution implements Runnable {

    private final BlockingQueue<Object> blockingQueue;


    public ProducerSolution(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Object object = produce();
                blockingQueue.put(object);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
