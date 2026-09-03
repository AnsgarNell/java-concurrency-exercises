package com.nellpy.workshops.concurrency.exercises.lock.exercise2.solution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Exercise2Solution {

    private static final int N_SIBLINGS = 4;


    static void main() {
        Lock controller1 = new ReentrantLock();
        Lock controller2 = new ReentrantLock();
        try(ExecutorService executorService = Executors.newFixedThreadPool(N_SIBLINGS)) {
            for (int i = 0; i < N_SIBLINGS; i++) {
                executorService.execute(new SiblingSolution(controller1, controller2));
            }
        }
    }

}
