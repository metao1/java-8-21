package com.metao.examples.designpatterns.factory.exp2;

public class MagicRoom implements Room {

    @Override
    public void connect(Room room) {
        System.out.println(getName() + " connects to :" + room.getName());
    }

    @Override
    public String getName() {
        return "magic-room";
    }
}