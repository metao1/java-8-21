package com.metao.examples.designpatterns.state;

/**
 * Common interface for all states.
 */
public abstract class State {
    final Player player;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onPause();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}
