package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.dp.visitor.Setting;
import com.metao.examples.designpatterns.dp.visitor.SettingType;

public interface ModemSettings {
    Setting getSetting(SettingType type);
}
