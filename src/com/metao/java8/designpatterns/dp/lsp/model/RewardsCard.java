package com.metao.java8.designpatterns.dp.lsp.model;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.service.PaymentInstrument;

public class RewardsCard implements PaymentInstrument {
    private final String name;
    private final String cardNumber;

    public RewardsCard(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void validate() throws PaymentInstrumentInvalidException {
        if (name == null || name.isEmpty()) {
            throw new PaymentInstrumentInvalidException("Name is invalid");
        }

        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new PaymentInstrumentInvalidException("Card number is invalid");
        }
        // Any other rewards card specific validations
    }

    @Override
    public PaymentResponse collectPayment() throws PaymentFailedException {
        PaymentResponse response = new PaymentResponse();
        // Steps related to rewards card payment like getting current rewards balance, debiting
        // balance etc.
        System.out.println("Updating rewards balance");
        response.setIdentifier(cardNumber);
        return response;
    }
}