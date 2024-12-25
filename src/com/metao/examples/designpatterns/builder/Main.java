package com.metao.examples.designpatterns.builder;

import com.metao.examples.designpatterns.builder.Hero;

public class Main {
    public static void main(String[] args) {
        com.metao.examples.designpatterns.builder.Hero crazyFrog = Hero.HeroBuilder
                .builder("Crazy Frog", "fighter")
                .hairColor("Black")
                .armor("Knife")
                .hairType("Blond")
                .weapon("DAGGER")
                .build();

        System.out.println(crazyFrog.getName() + " is a " + crazyFrog.getProfession());
    }
}
