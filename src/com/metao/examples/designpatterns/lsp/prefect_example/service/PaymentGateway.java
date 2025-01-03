package com.metao.examples.designpatterns.lsp.prefect_example.service;

import com.metao.examples.designpatterns.lsp.prefect_example.exception.PaymentFailedException;

import java.util.Date;
import java.util.UUID;

public class PaymentGateway {
    public String process(String name, String cardNumber, String verificationCode, Date expiryDate) throws PaymentFailedException {
        // sleep 2s to simulate network latency
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (cardNumber.startsWith("1")) {
            throw new PaymentFailedException("Payment failed!");
        }

        if (cardNumber.startsWith("2")) {
            throw new PaymentFailedException("Unrecognized card type, payment failed!");
        }
        return UUID.randomUUID().toString();
    }
}
