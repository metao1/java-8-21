package com.metao.examples.designpatterns.dp.visitor;

public class LinuxConfiguration implements Configuration {

    @Override
    public void config(Modem modem) {
        System.out.printf("Configuring modem %s for %s\n", modem.getModel().model(), osType().name());
    }

    @Override
    public OSType osType() {
        return OSType.LINUX;
    }
}
