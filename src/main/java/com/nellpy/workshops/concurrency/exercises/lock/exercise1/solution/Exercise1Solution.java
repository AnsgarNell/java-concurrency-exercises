package com.nellpy.workshops.concurrency.exercises.lock.exercise1.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Exercise1Solution {

    private static final int N_SIBLINGS = 4;


    static void main() {
        Lock lock = new ReentrantLock();
        try(ExecutorService executorService = Executors.newFixedThreadPool(N_SIBLINGS)) {
            for (int i = 0; i < N_SIBLINGS; i++) {
                executorService.execute(new SiblingSolution(lock));
            }
        }
    }

}
