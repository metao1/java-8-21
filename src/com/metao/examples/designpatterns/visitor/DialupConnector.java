package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.dp.visitor.Connector;
import com.metao.examples.designpatterns.dp.visitor.Modem;
import com.metao.examples.designpatterns.dp.visitor.SettingType;

import java.util.concurrent.atomic.AtomicBoolean;

public class DialupConnector implements Connector {

    AtomicBoolean connected = new AtomicBoolean(false);

    @Override
    public void connect(Modem modem) {
        ModemSettingReader settingReader = (ModemSettingReader) modem.getModel();
        System.out.printf("Modem setting: baudrate is %s \n", settingReader.getSetting(SettingType.FILE).baudrate());
        System.out.printf("Connecting via dialup to %s \n", modem.getModel().model());
        connected.set(true);
        System.out.printf("Connected to %s using dialup connector.\n", modem.getModel().model());
    }

    @Override
    public boolean isConnected() {
        return connected.get();
    }

}
