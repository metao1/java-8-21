package com.metao.examples.designpatterns.factory.exp2;

interface Room {
        void connect(Room room);

        String getName();
    }