package com.metao.examples.bad_practice_codes_refactoring;

import com.metao.examples.bad_practice_codes_refactoring.lib.Event;
import com.metao.examples.bad_practice_codes_refactoring.lib.State;

public class ImplementedClass2 implements Event {

    @Override
    public String type() {
        return "EVENT_2";
    }

    @Override
    public void process(State state) {
        state.accept(this);
    }
}
