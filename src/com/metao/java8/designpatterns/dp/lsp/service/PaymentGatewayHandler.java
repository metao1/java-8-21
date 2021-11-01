package com.metao.java8.designpatterns.dp.lsp.service;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.model.PaymentGatewayResponse;

public interface PaymentGatewayHandler {
    PaymentGatewayResponse handlePayment() throws PaymentFailedException;
}