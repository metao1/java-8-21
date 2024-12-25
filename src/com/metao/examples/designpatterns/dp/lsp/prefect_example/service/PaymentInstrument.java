package com.metao.examples.designpatterns.dp.lsp.prefect_example.service;

import com.metao.examples.designpatterns.dp.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.examples.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;
import com.metao.examples.designpatterns.dp.lsp.prefect_example.model.PaymentResponse;

public interface PaymentInstrument {
    void validate() throws PaymentInstrumentInvalidException;

    PaymentResponse collectPayment() throws PaymentFailedException;
}
