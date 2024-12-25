package com.metao.java8.designpatterns.dp.adapter.exp1;

public class MusicPlayer implements Music {

    private final Music music;

    MusicPlayer(Music music) {
        this.music = music;
    }

    @Override
    public void play() {
        music.play();
    }
}
