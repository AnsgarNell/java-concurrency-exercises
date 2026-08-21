package com.nellpy.workshops.concurrency.common;

import java.util.concurrent.Callable;


public class PrintingHelloCallable implements Callable<Void> {

    @Override
    public Void call() {
        System.out.println("Hello from a callable thread!");
        return null;
    }

}
