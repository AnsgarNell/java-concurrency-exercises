package com.nellpy.workshops.concurrency.exercises.executors.exercise4;

import com.nellpy.workshops.concurrency.common.TimeLoggingHelloRunnable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Exercise4 {

    static void main() {
        try(ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor()) {
            // TODO: Change the following code so that the message from the thread is printed every 1 second, with an initial delay of 5 seconds.
            scheduledExecutorService.execute(new TimeLoggingHelloRunnable());
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
