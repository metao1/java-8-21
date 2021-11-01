package com.metao.java8.designpatterns.dp.factory.exp2;

public class OrdinaryRoom implements Room {

    @Override
    public void connect(Room room) {
        System.out.println(getName() + " connects to :" + room.getName());
    }

    @Override
    public String getName() {
        return "ordinary-room";
    }
}