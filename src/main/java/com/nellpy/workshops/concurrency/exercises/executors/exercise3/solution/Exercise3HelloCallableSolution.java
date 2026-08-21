package com.nellpy.workshops.concurrency.exercises.executors.exercise3.solution;

import java.util.concurrent.Callable;


public class Exercise3HelloCallableSolution implements Callable<String> {

    @Override
    public String call() {
        return "Hello from callable thread " + Thread.currentThread().getName() + "!";
    }

}
