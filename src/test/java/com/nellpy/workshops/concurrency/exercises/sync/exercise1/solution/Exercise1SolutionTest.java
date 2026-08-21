package com.nellpy.workshops.concurrency.exercises.sync.exercise1.solution;


import com.nellpy.workshops.concurrency.exercises.sync.exercise1.Counter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Exercise1SolutionTest {

    @Test
    public void counter() {
        Counter counter = new SynchronizedCounter();
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