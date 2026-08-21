package com.nellpy.workshops.concurrency.common;

import java.util.concurrent.Callable;


public class HelloCallable implements Callable<String> {

    @Override
    public String call() {
        return "Hello from callable thread!";
    }

}
