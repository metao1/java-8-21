package com.metao.java8.designpatterns.dp.lsp.prefect_example.exception;

public class PaymentInstrumentInvalidException extends Exception {
    public PaymentInstrumentInvalidException(String message) {
        super(message);
    }
}
