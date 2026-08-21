package com.nellpy.workshops.concurrency.exercises.threads.exercise1;

import com.nellpy.workshops.concurrency.common.threads.SleepingHelloThread;


public class Exercise1 {

    static void main() throws InterruptedException {
        Thread thread = Thread.ofPlatform().unstarted(new SleepingHelloThread());
        // TODO: avoid thread keeping main alive
        thread.start();
        thread.join();
    }

}
