package com.metao.java8.messagebus;

public interface ConsumerEventListener<DR> {
    void onRead(DR dr);
}
