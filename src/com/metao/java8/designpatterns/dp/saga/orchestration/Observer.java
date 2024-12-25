package com.metao.java8.designpatterns.dp.saga.orchestration;

public interface Observer<T> {
    void onUpdate(T t);
}
