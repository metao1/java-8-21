package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Setting;
import com.metao.examples.designpatterns.visitor.SettingType;

public interface ModemSettings {
    Setting getSetting(SettingType type);
}
