package com.metao.examples.designpatterns.dp.lsp.prefect_example.exception;

public class PaymentInstrumentInvalidException extends Exception {
    public PaymentInstrumentInvalidException(String message) {
        super(message);
    }
}
