package com.metao.examples.designpatterns.saga.orchestration;

public interface Subject<T> {
    void registerObserver(Observer<T> observer);

    void unregisterObserver(Observer<T> observer);

    void notifyObservers(T object);
}
