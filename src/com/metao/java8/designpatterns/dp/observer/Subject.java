package com.metao.java8.designpatterns.dp.observer;

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}