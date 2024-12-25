package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Configuration;
import com.metao.examples.designpatterns.visitor.Modem;

public interface ConfigurationCallback {

    void accept(Modem modem, Configuration configuration);
}
