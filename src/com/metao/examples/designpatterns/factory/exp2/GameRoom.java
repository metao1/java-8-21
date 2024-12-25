package com.metao.examples.designpatterns.factory.exp2;

import java.util.LinkedList;
import java.util.List;

public abstract class GameRoom {
    private static final List<com.metao.examples.designpatterns.factory.exp2.Room> allRooms = new LinkedList<>();

    public GameRoom() {
        com.metao.examples.designpatterns.factory.exp2.Room room = createRoom();
        for (com.metao.examples.designpatterns.factory.exp2.Room otherRoom : getAllRooms()) {
            if (!otherRoom.getName().equals(room.getName())) {
                room.connect(otherRoom);
            }
        }
        allRooms.add(room);
    }

    public List<com.metao.examples.designpatterns.factory.exp2.Room> getAllRooms() {
        return allRooms;
    }

    protected abstract com.metao.examples.designpatterns.factory.exp2.Room createRoom();
}
