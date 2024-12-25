package com.metao.examples.bad_practice_codes_refactoring;

import com.metao.examples.bad_practice_codes_refactoring.lib.Event;
import com.metao.examples.bad_practice_codes_refactoring.lib.State;

public class EventState implements State {

    @Override
    public void accept(Event event) {
        System.out.println(event.type());
    }
}
