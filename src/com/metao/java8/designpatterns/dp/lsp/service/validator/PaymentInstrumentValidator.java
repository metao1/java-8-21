package com.metao.java8.designpatterns.dp.lsp.service.validator;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentInstrumentInvalidException;

public interface PaymentInstrumentValidator {
    public void validate() throws PaymentInstrumentInvalidException;
}