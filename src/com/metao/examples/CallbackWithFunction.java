package com.metao.examples;

import java.util.function.Consumer;
import java.util.function.Function;

public class CallbackWithFunction {

    public static void main(String[] args) {
        new CallbackWithFunction();
    }

    public CallbackWithFunction() {
        new FunctionClass<Integer, String>(null)
                .applyFunc(this::store)
                .thenConsume(System.out::println);
    }

    private String store(Integer item) {
        return String.valueOf(item);
    }

    static class FunctionClass<T, R> {

        private final T t;

        FunctionClass(T t) {
            this.t = t;
        }

        private FunctionClass<T, R> applyFunc(Function<T, R> function) {
            if (validate()) {
                function.apply(t);
            }
            return this;
        }

        private boolean validate() {
            return t != null;
        }

        private void thenConsume(Consumer<T> consumer) {
            if (validate()) {
                consumer.accept(t);
            }
        }

    }
}
