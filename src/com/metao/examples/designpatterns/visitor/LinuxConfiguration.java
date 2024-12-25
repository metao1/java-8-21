package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.dp.visitor.Configuration;
import com.metao.examples.designpatterns.dp.visitor.Modem;
import com.metao.examples.designpatterns.dp.visitor.OSType;

public class LinuxConfiguration implements Configuration {

    @Override
    public void config(Modem modem) {
        System.out.printf("Configuring modem %s for %s\n", modem.getModel().model(), osType().name());
    }

    @Override
    public com.metao.examples.designpatterns.dp.visitor.OSType osType() {
        return OSType.LINUX;
    }
}
