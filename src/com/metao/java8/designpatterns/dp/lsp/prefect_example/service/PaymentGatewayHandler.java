package com.metao.java8.designpatterns.dp.lsp.prefect_example.service;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.model.PaymentGatewayResponse;

public interface PaymentGatewayHandler {
    PaymentGatewayResponse handlePayment() throws PaymentFailedException;
}