package com.metao.java8.designpatterns.dp.factory.exp2;

class BasicGame extends GameRoom {

    @Override
    protected Room createRoom() {
        return new OrdinaryRoom();
    }
}
