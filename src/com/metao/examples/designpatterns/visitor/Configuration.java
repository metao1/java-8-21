package com.metao.examples.designpatterns.visitor;

import com.metao.examples.designpatterns.dp.visitor.Modem;
import com.metao.examples.designpatterns.dp.visitor.OSTypeReader;

public interface Configuration extends OSTypeReader {
    void config(Modem modem);
}
