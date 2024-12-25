package com.metao.examples.designpatterns.dp.saga.orchestration;

public interface Observer<T> {
    void onUpdate(T t);
}
