package com.nellpy.workshops.concurrency.exercises.executors.exercise3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Exercise3 {

    static void main() throws ExecutionException, InterruptedException {
        try(ExecutorService executorService = Executors.newCachedThreadPool()) {
            // TODO: Create 10 new Exercise3HelloCallableSolution instances, and print the result message in the console
            // Make sure every message also contains the information about the thread it was created in
            Future<String> future = executorService.submit(new Exercise3HelloCallable());
            String message = future.get();
            System.out.println(message);
        }
    }
}
