package com.metao.examples.designpatterns.dp.visitor;

public class TpLinkSettingReader implements ModemSettingReader {

    @Override
    public String model() {
        return "TL-WR841N";
    }

    @Override
    public Setting getSetting(SettingType type) {
        return () -> 12 + " Mbps";
    }
}
