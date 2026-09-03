package com.nellpy.workshops.concurrency.exercises.semaphores.exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Exercise1 {

    private static final int N_SIBLINGS = 10;

    // TODO: Modify the code using a Semaphore so that up to 4 PS4 controllers can be used at the same time


    static void main() {
        Lock controller1 = new ReentrantLock();
        try(ExecutorService executorService = Executors.newFixedThreadPool(N_SIBLINGS)) {
            for (int i = 0; i < N_SIBLINGS; i++) {
                executorService.execute(new Sibling(controller1));
            }
        }
    }

}
