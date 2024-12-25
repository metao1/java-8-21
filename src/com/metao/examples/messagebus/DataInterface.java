package com.metao.examples.messagebus;

import java.util.function.Consumer;
import java.util.function.Supplier;

interface DataInterface<T> extends Consumer<T>, Supplier<T> {
    void stop();
}
    