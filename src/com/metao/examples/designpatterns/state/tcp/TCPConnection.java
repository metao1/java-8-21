package com.metao.examples.designpatterns.state.tcp;

public class TCPConnection {

    private TCPState tcpState;
    private final com.metao.examples.designpatterns.state.tcp.Connection connection = new Connection();
    private final com.metao.examples.designpatterns.state.tcp.TCPEstablish tcpEstablish = new TCPEstablish(connection);
    private final com.metao.examples.designpatterns.state.tcp.TCPListen tcpListen = new TCPListen(connection);
    private final com.metao.examples.designpatterns.state.tcp.TCPClose tcpClose = new TCPClose(connection);

    public void openConnection() {
        this.tcpState = tcpEstablish;
        this.tcpState.send(new com.metao.examples.designpatterns.state.tcp.Packet(0, "SYN"));
        this.tcpState.open();
        this.tcpState = tcpListen;
    }

    public void closeConnection() {
        this.tcpState = tcpClose;
        this.tcpState.close();
        this.tcpState.send(new com.metao.examples.designpatterns.state.tcp.Packet(0, "CLOSE"));
    }

    public void sendPacket(final Packet packet) {
        this.tcpState.send(packet);
    }

    public State getTCPState() {
        return connection.getState();
    }

}
