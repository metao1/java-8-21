package com.metao.examples.designpatterns.dp.lsp.prefect_example.model;

import java.util.Date;

import com.metao.examples.designpatterns.dp.lsp.prefect_example.service.BaseBankCard;
import com.metao.examples.designpatterns.dp.lsp.prefect_example.service.FraudChecker;
import com.metao.examples.designpatterns.dp.lsp.prefect_example.service.PaymentGatewayHandler;
import com.metao.examples.designpatterns.dp.lsp.prefect_example.service.validator.PaymentInstrumentValidator;

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
