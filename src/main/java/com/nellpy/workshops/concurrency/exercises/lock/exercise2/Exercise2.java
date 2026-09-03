package com.nellpy.workshops.concurrency.exercises.lock.exercise2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Exercise2 {

    private static final int N_SIBLINGS = 4;

    // TODO: Modify the code in the Sibling class so that both controllers of the PS4 are used:
    // Try to get controller 1 for 5 seconds, if it is being used, try to get controller 2 for 5 seconds, if not start trying again


    static void main() {
        Lock controller1 = new ReentrantLock();
        try(ExecutorService executorService = Executors.newFixedThreadPool(N_SIBLINGS)) {
            for (int i = 0; i < N_SIBLINGS; i++) {
                executorService.execute(new Sibling(controller1));
            }
        }
    }

}
