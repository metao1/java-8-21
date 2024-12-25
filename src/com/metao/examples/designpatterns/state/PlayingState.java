package com.metao.examples.designpatterns.state;

import com.metao.examples.designpatterns.dp.state.PauseState;
import com.metao.examples.designpatterns.dp.state.Player;
import com.metao.examples.designpatterns.dp.state.ReadyState;
import com.metao.examples.designpatterns.dp.state.State;

public class PlayingState extends State {

    PlayingState(Player player) {
        super(player);
    }

    @Override
    public String onPause() {
        player.changeState(new PauseState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    public String onNext() {
        return player.nextTrack();
    }

    @Override
    public String onPrevious() {
        return player.previousTrack();
    }
}
