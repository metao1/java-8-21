package com.metao.java8.designpatterns.dp.lsp.prefect_example.exception;

public class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}
