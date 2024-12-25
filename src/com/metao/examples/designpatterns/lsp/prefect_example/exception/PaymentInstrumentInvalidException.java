package com.metao.examples.designpatterns.lsp.prefect_example.exception;

public class PaymentInstrumentInvalidException extends Exception {
    public PaymentInstrumentInvalidException(String message) {
        super(message);
    }
}
