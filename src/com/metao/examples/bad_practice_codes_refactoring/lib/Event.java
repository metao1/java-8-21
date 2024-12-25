package com.metao.examples.bad_practice_codes_refactoring.lib;

public interface Event {

    String type();

    void process(State state);
}
