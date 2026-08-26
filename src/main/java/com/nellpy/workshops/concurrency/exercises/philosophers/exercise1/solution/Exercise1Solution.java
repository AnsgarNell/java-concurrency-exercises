package com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.solution;

import com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.ForkPair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Exercise1Solution {

    private static final int NUMBER_OF_PHILOSOPHERS = 5;


    static void main() {
        List<Lock> forks = new ArrayList<>(NUMBER_OF_PHILOSOPHERS);
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            forks.add(new ReentrantLock());
        }
        for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
            // Extra question: Why didn't we have to change the ForkPair definition?
            ForkPair forkPair = new ForkPair(forks.get(i), forks.get((i + 1) % NUMBER_OF_PHILOSOPHERS));
            PhilosopherSolution philosopherSolution = getPhilosopher(i, forkPair);
            createThread(philosopherSolution, i);
        }
    }


    private static PhilosopherSolution getPhilosopher(int i, ForkPair forkPair) {
        if (i == 0) {
            return new SwitchedPhilosopherSolution(forkPair);
        } else {
            return new PhilosopherSolution(forkPair);
        }
    }


    private static void createThread(PhilosopherSolution philosopherSolution, int i) {
        Thread thread = Thread.ofPlatform()
                .unstarted(philosopherSolution);
        thread.setName("Philosopher " + (i + 1));
        thread.start();
    }

}
