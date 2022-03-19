package com.metao.java8.designpatterns.dp.lsp.prefect_example.service.validator;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;

public interface PaymentInstrumentValidator {
    public void validate() throws PaymentInstrumentInvalidException;
}