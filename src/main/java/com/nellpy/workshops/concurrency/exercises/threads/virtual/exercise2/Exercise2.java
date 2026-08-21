package com.nellpy.workshops.concurrency.exercises.threads.virtual.exercise2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise2 {

    static void main() {
        // TODO: Fix following code using Virtual Threads, and print in the console if the thread is virtual or not
        try(ExecutorService executorService = Executors.newFixedThreadPool(100_000)) {
            for (int i = 0; i < 100_000; i++) {
                executorService.execute(new Exercise2HelloRunnable());
            }
        }
    }
}
