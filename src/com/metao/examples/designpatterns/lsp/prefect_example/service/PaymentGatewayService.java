package com.metao.examples.designpatterns.lsp.prefect_example.service;

import com.metao.examples.designpatterns.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.examples.designpatterns.lsp.prefect_example.model.PaymentGatewayResponse;
import com.metao.examples.designpatterns.lsp.prefect_example.service.PaymentGateway;
import com.metao.examples.designpatterns.lsp.prefect_example.service.PaymentGatewayHandler;

import java.util.Date;

public class PaymentGatewayService implements PaymentGatewayHandler {
    String name;
    String cardNumber;
    String verificationCode;
    Date expiryDate;
    com.metao.examples.designpatterns.lsp.prefect_example.service.PaymentGateway gateway = new PaymentGateway();

    public PaymentGatewayService(String name, String cardNumber, String verificationCode, Date expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.verificationCode = verificationCode;
        this.expiryDate = expiryDate;
    }

    @Override
    public PaymentGatewayResponse handlePayment() throws PaymentFailedException {
        // send details to payment gateway (PG) and save the fingerprint
        // received from PG
        System.out.println("Sending details to payment gateway");
        String fingerprint = gateway.process(name, cardNumber, verificationCode, expiryDate);
        PaymentGatewayResponse pgResponse = new PaymentGatewayResponse();
        pgResponse.setFingerprint(fingerprint);
        System.out.println("Payment gateway response received");

        return pgResponse;
    }

}
