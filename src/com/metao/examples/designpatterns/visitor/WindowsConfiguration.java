package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Configuration;
import com.metao.examples.designpatterns.visitor.Modem;
import com.metao.examples.designpatterns.visitor.OSType;

public class WindowsConfiguration implements Configuration {

    @Override
    public void config(Modem modem) {
        System.out.printf("Configuring modem %s for %s\n", modem.getModel().model(), osType().name());
    }

    @Override
    public com.metao.examples.designpatterns.visitor.OSType osType() {
        return OSType.WINDOWS;
    }
}
