package com.metao.examples.designpatterns.ami;

import com.metao.examples.designpatterns.dp.ami.AsyncCallback;
import com.metao.examples.designpatterns.dp.ami.AsyncResult;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public interface AsyncExecutor {

    public  <T> com.metao.examples.designpatterns.dp.ami.AsyncResult<T> startProcess(Callable<T> callable);

    public <T> com.metao.examples.designpatterns.dp.ami.AsyncResult<T> startProcess(Callable<T> callable, AsyncCallback<T> ac);

    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;

}
