package com.nellpy.workshops.concurrency.exercises.atomic.exercise1;


import com.nellpy.workshops.concurrency.common.counter.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Exercise1Test {

    @Test
    public void counter() {
        // TODO: Implement a thread-safe Counter class using an Atomic variable
        Counter counter = new ThreadUnsafeCounter();
        Assertions.assertEquals(0, counter.value());
        try(ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 100_000; i++) {
                executorService.submit(counter::increment);
                executorService.submit(counter::decrement);
            }
        }
        Assertions.assertEquals(0, counter.value());
    }

}