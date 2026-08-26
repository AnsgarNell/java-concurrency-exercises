package com.nellpy.workshops.concurrency.exercises.philosophers.exercise1;

import java.util.concurrent.locks.Lock;


public record ForkPair(Lock firstFork, Lock secondFork) {

}
