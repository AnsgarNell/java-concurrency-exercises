package com.nellpy.workshops.concurrency.exercises.semaphores.exercise1.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class Exercise1Solution {

    private static final int N_SIBLINGS = 10;


    static void main() {
        Semaphore controllers = new Semaphore(4);
        try(ExecutorService executorService = Executors.newFixedThreadPool(N_SIBLINGS)) {
            for (int i = 0; i < N_SIBLINGS; i++) {
                executorService.execute(new SiblingSolution(controllers));
            }
        }
    }

}
