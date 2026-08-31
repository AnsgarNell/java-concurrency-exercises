package com.nellpy.workshops.concurrency.exercises.queues.exercise1.solution;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Exercise1Solution {

    static void main() {
        BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>();
        Thread.ofPlatform().start(new ProducerSolution(blockingQueue));
        Thread.ofPlatform().start(new ConsumerSolution(blockingQueue));
        Thread.ofPlatform().start(new ConsumerSolution(blockingQueue));
    }

}
