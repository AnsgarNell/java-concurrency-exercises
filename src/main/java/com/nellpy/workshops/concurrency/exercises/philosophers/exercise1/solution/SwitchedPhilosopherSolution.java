package com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.solution;


import com.nellpy.workshops.concurrency.exercises.philosophers.exercise1.ForkPair;


public class SwitchedPhilosopherSolution extends PhilosopherSolution {


    public SwitchedPhilosopherSolution(ForkPair forkPair) {
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
