package com.metao.examples.designpatterns.solid;

public class Bike implements Vehicle {

    public void turnOnEngine() {
        throw new AssertionError("I don't have an engine!");
    }

    public void accelerate() {
        //this acceleration is crazy!
    }
}