package com.metao.examples.designpatterns.lsp.prefect_example.service;

import com.metao.examples.designpatterns.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.examples.designpatterns.lsp.prefect_example.model.PaymentGatewayResponse;

public interface PaymentGatewayHandler {
    PaymentGatewayResponse handlePayment() throws PaymentFailedException;
}