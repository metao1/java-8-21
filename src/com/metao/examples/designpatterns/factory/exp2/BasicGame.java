package com.metao.examples.designpatterns.factory.exp2;

class BasicGame extends GameRoom {

    @Override
    protected Room createRoom() {
        return new OrdinaryRoom();
    }
}
