package com.nellpy.workshops.concurrency.exercises.executors.exercise2.solution;

import com.nellpy.workshops.concurrency.common.threads.HelloCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Exercise2Solution {

    static void main() throws ExecutionException, InterruptedException {
        try(ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            Future<String> future = executorService.submit(new HelloCallable());
            String message = future.get();
            System.out.println(message);
        }
    }
}
