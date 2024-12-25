package com.metao.examples.designpatterns.dp.factory.exp2;

interface Room {
        void connect(Room room);

        String getName();
    }