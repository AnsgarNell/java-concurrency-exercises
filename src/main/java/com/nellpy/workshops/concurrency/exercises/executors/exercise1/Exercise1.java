package com.nellpy.workshops.concurrency.exercises.executors.exercise1;

import com.nellpy.workshops.concurrency.common.threads.HelloRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise1 {

    static void main() {
        try(ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            // TODO: Change following line to use PrintingHelloCallable instead of HelloRunnable
            executorService.execute(new HelloRunnable());
        }
    }
}
