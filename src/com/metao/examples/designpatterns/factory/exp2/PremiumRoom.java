package com.metao.examples.designpatterns.factory.exp2;

import com.metao.examples.designpatterns.dp.factory.exp2.GameRoom;
import com.metao.examples.designpatterns.dp.factory.exp2.MagicRoom;
import com.metao.examples.designpatterns.dp.factory.exp2.Room;

class PremiumRoom extends GameRoom {

    @Override
    protected com.metao.examples.designpatterns.dp.factory.exp2.Room createRoom() {
        return new MagicRoom();
    }
}