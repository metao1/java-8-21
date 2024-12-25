package com.metao.examples.designpatterns.factory.exp2;

import com.metao.examples.designpatterns.dp.factory.exp2.Room;

public class MagicRoom implements com.metao.examples.designpatterns.dp.factory.exp2.Room {

    @Override
    public void connect(com.metao.examples.designpatterns.dp.factory.exp2.Room room) {
        System.out.println(getName() + " connects to :" + room.getName());
    }

    @Override
    public String getName() {
        return "magic-room";
    }
}