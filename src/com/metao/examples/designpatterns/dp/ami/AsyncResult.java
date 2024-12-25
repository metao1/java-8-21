package com.metao.examples.designpatterns.dp.ami;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    boolean isCompleted();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
