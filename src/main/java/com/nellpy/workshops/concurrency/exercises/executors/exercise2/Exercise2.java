package com.nellpy.workshops.concurrency.exercises.executors.exercise2;

import com.nellpy.workshops.concurrency.common.HelloCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Exercise2 {

    static void main() {
        try(ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            // TODO: print thread message in console
            executorService.submit(new HelloCallable());
        }
    }
}
