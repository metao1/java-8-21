package com.metao.examples.designpatterns.factory.exp2;

class BasicGame extends GameRoom {

    @Override
    protected com.metao.examples.designpatterns.factory.exp2.Room createRoom() {
        return new OrdinaryRoom();
    }
}
