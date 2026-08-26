package com.nellpy.workshops.concurrency.exercises.philosophers.exercise1;


public class SwitchedPhilosopher extends Philosopher {


    public SwitchedPhilosopher(ForkPair forkPair) {
        super(forkPair.secondFork(), forkPair.firstFork());
    }


    @Override
    protected String getFirstForkName() {
        return RIGHT;
    }


    @Override
    protected String getSecondForkName() {
        return LEFT;
    }
}
