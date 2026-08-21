package com.nellpy.workshops.concurrency.exercises.executors.exercise4.solution;

import com.nellpy.workshops.concurrency.common.TimeLoggingHelloRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Exercise4Solution {

    static void main() {
        try(ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor()) {
            scheduledExecutorService.scheduleWithFixedDelay(new TimeLoggingHelloRunnable(), 5, 1, TimeUnit.SECONDS);
            pauseMainThreadExecution();
        }
    }


    private static void pauseMainThreadExecution() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
