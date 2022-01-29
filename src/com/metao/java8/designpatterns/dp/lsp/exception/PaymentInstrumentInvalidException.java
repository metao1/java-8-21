package com.metao.java8.designpatterns.dp.lsp.exception;

public class PaymentInstrumentInvalidException extends Exception {
    public PaymentInstrumentInvalidException(String message) {
        super(message);
    }
}
