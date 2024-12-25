package com.metao.java8.reactive;

public interface Message<T> {
    T getPayload();
}