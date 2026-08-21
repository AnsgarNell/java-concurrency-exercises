package com.nellpy.workshops.concurrency.exercises.executors.exercise3.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Exercise3Solution {

    static void main() throws ExecutionException, InterruptedException {
        try(ExecutorService executorService = Executors.newCachedThreadPool()) {
            List<Callable<String>> callables = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                callables.add(new Exercise3HelloCallableSolution());
            }
            List<Future<String>> futures = executorService.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        }
    }
}
