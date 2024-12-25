package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.visitor.Modem;
import com.metao.examples.designpatterns.visitor.OSTypeReader;

public interface Configuration extends OSTypeReader {
    void config(Modem modem);
}
