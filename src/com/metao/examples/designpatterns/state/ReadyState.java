package com.metao.examples.designpatterns.state;

import com.metao.examples.designpatterns.dp.state.PauseState;
import com.metao.examples.designpatterns.dp.state.Player;
import com.metao.examples.designpatterns.dp.state.PlayingState;
import com.metao.examples.designpatterns.dp.state.State;

public class ReadyState extends State {

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onPause() {
        player.changeState(new PauseState(player));
        return "Paused...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return "Paused...";
    }

    @Override
    public String onPrevious() {
        return "Paused...";
    }
}
