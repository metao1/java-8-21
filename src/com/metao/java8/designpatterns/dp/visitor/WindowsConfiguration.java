package com.metao.java8.designpatterns.dp.visitor;

public class WindowsConfiguration implements Configuration {

    @Override
    public void config(Modem modem) {
        System.out.printf("Configuring modem %s for %s\n", modem.getModel().model(), osType().name());
    }

    @Override
    public OSType osType() {
        return OSType.WINDOWS;
    }
}
