package com.metao.examples.designpatterns.dp.factory.exp2;

class PremiumRoom extends GameRoom {

    @Override
    protected Room createRoom() {
        return new MagicRoom();
    }
}