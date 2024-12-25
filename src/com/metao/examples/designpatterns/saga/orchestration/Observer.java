package com.metao.examples.designpatterns.saga.orchestration;

public interface Observer<T> {
    void onUpdate(T t);
}
