package com.nellpy.workshops.concurrency.exercises.threads.virtual.exercise1;

import com.nellpy.workshops.concurrency.common.NamedHelloRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise1 {

    static void main() {
        // TODO: Change the following code so that Virtual Threads are used and check if the Fork/Join Pool is used
        try(ExecutorService executorService = Executors.newSingleThreadScheduledExecutor()) {
            executorService.execute(new NamedHelloRunnable());
        }
    }
}
