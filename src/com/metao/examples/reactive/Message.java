package com.metao.examples.reactive;

public interface Message<T> {
    T getPayload();
}