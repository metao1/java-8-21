package com.metao.java8.designpatterns.dp.ami;

import java.util.concurrent.ExecutionException;

public interface AsyncResult<T> {

    boolean isCompleted();

    T getValue() throws ExecutionException;

    void await() throws InterruptedException;
}
