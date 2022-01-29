package com.metao.java8.designpatterns.dp.factory.exp2;

interface Room {
        void connect(Room room);

        String getName();
    }