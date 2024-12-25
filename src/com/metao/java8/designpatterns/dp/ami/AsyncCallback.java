package com.metao.java8.designpatterns.dp.ami;

import java.util.Optional;

public interface AsyncCallback<T> {

    void onComplete(T value, Optional<Exception> ex);
}
