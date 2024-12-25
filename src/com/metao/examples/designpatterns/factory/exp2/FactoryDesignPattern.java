package com.metao.examples.designpatterns.factory.exp2;

public class FactoryDesignPattern {

    public static void main(String[] args) {
        GameRoom basicGame = new BasicGame();
        GameRoom premiumGame = new PremiumRoom();
    }

}
