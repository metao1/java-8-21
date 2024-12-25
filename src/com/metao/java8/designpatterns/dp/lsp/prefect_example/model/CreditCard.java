package com.metao.java8.designpatterns.dp.lsp.prefect_example.model;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.service.BaseBankCard;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.service.FraudChecker;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.service.PaymentGatewayHandler;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.service.validator.PaymentInstrumentValidator;

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
        super.validate();
        // additional validations for credit cards
    }

}