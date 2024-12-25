package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Configuration;
import com.metao.examples.designpatterns.visitor.Modem;

public class Demo {
    public static void main(String[] args) {
        Modem modem = new TpLinkModem(((modem1, configuration) -> {
            System.out.printf("Configured modem %s for %s\n", modem1.getModel().model(), configuration.osType().name());
        }));
        Configuration configuration = new WindowsConfiguration();
        modem.config(configuration);
        modem.connect(new DialupConnector());
        configuration = new LinuxConfiguration();
        modem.config(configuration);
        modem.connect(new DialupConnector());
    }
}
