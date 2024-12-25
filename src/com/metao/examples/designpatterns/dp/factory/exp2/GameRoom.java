package com.metao.examples.designpatterns.dp.factory.exp2;

import java.util.LinkedList;
import java.util.List;

public abstract class GameRoom {
    private static final List<Room> allRooms = new LinkedList<>();

    public GameRoom() {
        Room room = createRoom();
        for (Room otherRoom : getAllRooms()) {
            if (!otherRoom.getName().equals(room.getName())) {
                room.connect(otherRoom);
            }
        }
        allRooms.add(room);
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

    protected abstract Room createRoom();
}
