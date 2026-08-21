package com.nellpy.workshops.concurrency.exercises.executors.exercise3;

import java.util.concurrent.Callable;


public class Exercise3HelloCallable implements Callable<String> {

    @Override
    public String call() {
        return "Hello from callable thread!";
    }

}
