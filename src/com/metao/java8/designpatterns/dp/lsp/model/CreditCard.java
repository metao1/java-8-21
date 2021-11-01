package com.metao.java8.designpatterns.dp.lsp.model;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.service.BaseBankCard;
import com.metao.java8.designpatterns.dp.lsp.service.FraudChecker;
import com.metao.java8.designpatterns.dp.lsp.service.PaymentGatewayHandler;
import com.metao.java8.designpatterns.dp.lsp.service.validator.PaymentInstrumentValidator;

import java.util.Date;

public class CreditCard extends BaseBankCard {

    public CreditCard(String name,
                      String cardNumber,
                      String verificationCode,
                      Date expiryDate,
                      PaymentInstrumentValidator basicValidator,
                      FraudChecker fraudChecker,
                      PaymentGatewayHandler gatewayHandler) {
        super(name, cardNumber, verificationCode, expiryDate, basicValidator, fraudChecker, gatewayHandler);
    }

    @Override
    public void validate() throws PaymentInstrumentInvalidException {
        basicValidator.validate();
        // additional validations for credit cards
    }

}