package com.metao.java8.messagebus;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

abstract class EventHandler<U> extends TimerTask {
    protected final List<ConsumerEventListener<U>> dataListeners = new LinkedList<>();
}