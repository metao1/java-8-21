package com.metao.examples.designpatterns.saga.orchestration;

import com.metao.examples.designpatterns.saga.orchestration.Observer;
import com.metao.examples.designpatterns.saga.orchestration.Subject;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class StringObserverHandler implements Subject<String> {

    private final Queue<com.metao.examples.designpatterns.saga.orchestration.Observer<String>> observers = new ConcurrentLinkedDeque<>();

    @Override
    public void registerObserver(com.metao.examples.designpatterns.saga.orchestration.Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String object) {
        observers.parallelStream().forEach((observer) -> observer.onUpdate(object));
    }
}
