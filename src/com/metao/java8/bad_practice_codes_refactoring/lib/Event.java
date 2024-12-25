package com.metao.java8.bad_practice_codes_refactoring.lib;

public interface Event {

    String type();

    void process(State state);
}
