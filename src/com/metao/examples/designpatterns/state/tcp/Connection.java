package com.metao.examples.designpatterns.state.tcp;

import com.metao.examples.designpatterns.state.tcp.Packet;
import com.metao.examples.designpatterns.state.tcp.State;

public class Connection {
    private com.metao.examples.designpatterns.state.tcp.State state = com.metao.examples.designpatterns.state.tcp.State.CLOSED;

    public void open() {
        this.state = com.metao.examples.designpatterns.state.tcp.State.OPENED;
    }

    public void close() {
        this.state = com.metao.examples.designpatterns.state.tcp.State.CLOSED;
    }

    public boolean isOpen() {
        return this.state == com.metao.examples.designpatterns.state.tcp.State.OPENED;
    }

    public void send(final Packet packet) {
        System.out.printf("packet= %s sent.%n", packet.toString());
    }

    public State getState() {
        return state;
    }
}