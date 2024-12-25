package com.metao.java8.designpatterns.dp.factory.exp2;

import java.util.LinkedList;
import java.util.List;

public class FactoryDesignPattern {



    public static void main(String[] args) {
        GameRoom basicGame = new BasicGame();
        GameRoom premiumGame = new PremiumRoom();
    }

}
