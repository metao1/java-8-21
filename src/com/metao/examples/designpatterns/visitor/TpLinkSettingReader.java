package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.ModemSettingReader;
import com.metao.examples.designpatterns.visitor.Setting;
import com.metao.examples.designpatterns.visitor.SettingType;

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
