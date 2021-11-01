package com.metao.java8.designpatterns.dp.lsp.service;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.model.PaymentResponse;

public interface PaymentInstrument {
    void validate() throws PaymentInstrumentInvalidException;

    PaymentResponse collectPayment() throws PaymentFailedException;
}
