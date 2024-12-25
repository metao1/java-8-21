package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Configuration;
import com.metao.examples.designpatterns.visitor.Connector;
import com.metao.examples.designpatterns.visitor.Modem;
import com.metao.examples.designpatterns.visitor.ModemSettingReader;

public class TpLinkModem implements Modem {

    private final ModemSettingReader tpLinkSettingReader = new TpLinkSettingReader();
    private final ConfigurationCallback configurationCallback;

    TpLinkModem(ConfigurationCallback configurationCallback) {
        this.configurationCallback = configurationCallback;
    }

    @Override
    public void config(Configuration configuration) {
        configuration.config(this);
        configurationCallback.accept(this, configuration);
    }

    @Override
    public void connect(Connector connector) {
        if (!connector.isConnected()) {
            connector.connect(this);
        }
    }

    @Override
    public void disconnect() {
        // do nothing
    }

    @Override
    public byte[] read() {
        System.out.println("Reading from TpLink modem");
        return new byte[0];
    }

    @Override
    public void write(byte[] data) {
        System.out.println("Writing data to TpLinkModem");
    }

    @Override
    public ModemSettingReader getModel() {
        return this.tpLinkSettingReader;
    }
}
