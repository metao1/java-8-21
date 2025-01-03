package com.metao.examples.designpatterns.ami;

import java.util.Optional;

public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> ex);
}
