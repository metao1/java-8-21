package com.metao.examples.designpatterns.state.tcp;

import com.metao.examples.designpatterns.state.tcp.Packet;

public interface TCPState {
    public void open();

    public void close();

    public void acknowledge(final long packetId);

    public void send(final Packet packet);
}