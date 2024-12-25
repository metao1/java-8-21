package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.dp.visitor.Configuration;
import com.metao.examples.designpatterns.dp.visitor.Modem;

public interface ConfigurationCallback {

    void accept(Modem modem, Configuration configuration);
}
