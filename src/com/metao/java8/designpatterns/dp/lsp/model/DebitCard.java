package com.metao.java8.designpatterns.dp.lsp.model;

import com.metao.java8.designpatterns.dp.lsp.service.FraudChecker;
import com.metao.java8.designpatterns.dp.lsp.service.PaymentGatewayHandler;
import com.metao.java8.designpatterns.dp.lsp.service.validator.PaymentInstrumentValidator;
import com.metao.java8.designpatterns.dp.lsp.service.BaseBankCard;

import java.util.Date;

public class DebitCard extends BaseBankCard {

    public DebitCard(String name,
                     String cardNumber,
                     String verificationCode,
                     Date expiryDate,
                     PaymentInstrumentValidator basicValidator,
                     FraudChecker fraudChecker,
                     PaymentGatewayHandler gatewayHandler) {
        super(name, cardNumber, verificationCode, expiryDate, basicValidator, fraudChecker, gatewayHandler);
    }
}
