package com.nellpy.workshops.concurrency.exercises.threads.virtual.exercise2.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise2Solution {

    static void main() {
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100_000; i++) {
                executorService.execute(new Exercise2HelloRunnableSolution());
            }
        }
    }
}
