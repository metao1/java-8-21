package com.metao.examples.designpatterns.adapter.exp1;

public class MusicPlayer implements com.metao.examples.designpatterns.adapter.exp1.Music {

    private final com.metao.examples.designpatterns.adapter.exp1.Music music;

    MusicPlayer(Music music) {
        this.music = music;
    }

    @Override
    public void play() {
        music.play();
    }
}
