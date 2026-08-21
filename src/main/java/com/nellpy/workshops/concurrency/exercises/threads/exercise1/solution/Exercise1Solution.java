package com.nellpy.workshops.concurrency.exercises.threads.exercise1.solution;

import com.nellpy.workshops.concurrency.common.SleepingHelloThread;


public class Exercise1Solution {

    static void main() {
        Thread thread = Thread.ofPlatform().unstarted(new SleepingHelloThread());
        thread.setDaemon(true);
        thread.start();
    }

}
