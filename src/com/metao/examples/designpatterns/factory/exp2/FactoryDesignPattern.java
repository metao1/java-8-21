package com.metao.examples.designpatterns.factory.exp2;

public class FactoryDesignPattern {



    public static void main(String[] args) {
        com.metao.examples.designpatterns.factory.exp2.GameRoom basicGame = new com.metao.examples.designpatterns.factory.exp2.BasicGame();
        GameRoom premiumGame = new com.metao.examples.designpatterns.factory.exp2.PremiumRoom();
    }

}
