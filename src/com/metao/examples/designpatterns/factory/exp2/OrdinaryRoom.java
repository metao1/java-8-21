package com.metao.examples.designpatterns.factory.exp2;

public class OrdinaryRoom implements com.metao.examples.designpatterns.factory.exp2.Room {

    @Override
    public void connect(com.metao.examples.designpatterns.factory.exp2.Room room) {
        System.out.println(getName() + " connects to :" + room.getName());
    }

    @Override
    public String getName() {
        return "ordinary-room";
    }
}