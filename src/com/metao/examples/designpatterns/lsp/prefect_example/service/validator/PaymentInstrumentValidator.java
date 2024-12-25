package com.metao.examples.designpatterns.lsp.prefect_example.service.validator;

import com.metao.examples.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;

public interface PaymentInstrumentValidator {
    public void validate() throws PaymentInstrumentInvalidException;
}