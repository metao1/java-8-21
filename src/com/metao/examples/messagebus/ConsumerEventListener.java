package com.metao.examples.messagebus;

public interface ConsumerEventListener<DR> {
    void onRead(DR dr);
}
