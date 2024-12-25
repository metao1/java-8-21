package com.metao.examples.designpatterns.adapter.exp1;

import com.metao.examples.designpatterns.dp.adapter.exp1.Mp3;
import com.metao.examples.designpatterns.dp.adapter.exp1.Mp4;

public class Demo {

    public static void main(String[] args) {
        com.metao.examples.designpatterns.dp.adapter.exp1.Mp3 mp3 = new Mp3("/tmp/file.mp3");
        Music musicPlayer = new MusicPlayer(mp3);
        musicPlayer.play();
        com.metao.examples.designpatterns.dp.adapter.exp1.Mp4 mp4 = new Mp4("/tmp/file.mp4");
        Music musicPlayer2 = new MusicPlayer(mp4);
        musicPlayer2.play();
    }
}
