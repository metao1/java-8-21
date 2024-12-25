package com.metao.java8.designpatterns.dp.lsp.prefect_example.service;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.FraudDetectedException;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.model.PaymentGatewayResponse;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.model.PaymentResponse;
import com.metao.java8.designpatterns.dp.lsp.prefect_example.service.validator.PaymentInstrumentValidator;

import java.util.Date;

public abstract class BaseBankCard implements PaymentInstrument {
  String name;
  String cardNumber;
  String verificationCode;
  Date expiryDate;
  protected FraudChecker fraudChecker;
  protected PaymentGatewayHandler gatewayHandler;
  protected PaymentInstrumentValidator basicValidator;

  protected BaseBankCard(String name,
      String cardNumber,
      String verificationCode,
      Date expiryDate,
      PaymentInstrumentValidator basicValidator,
      FraudChecker fraudChecker,
      PaymentGatewayHandler gatewayHandler) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.verificationCode = verificationCode;
    this.expiryDate = expiryDate;
    this.basicValidator = basicValidator;
    this.fraudChecker = fraudChecker;
    this.gatewayHandler = gatewayHandler;
  }

  @Override
  public void validate() throws PaymentInstrumentInvalidException {
    basicValidator.validate();
  }

  @Override
  public PaymentResponse collectPayment() throws PaymentFailedException {
    PaymentResponse response = new PaymentResponse();
    try {
      fraudChecker.runChecks();
      PaymentGatewayResponse pgResponse = gatewayHandler.handlePayment();
      response.setIdentifier(pgResponse.getFingerprint());
    } catch (FraudDetectedException e) {
      e.printStackTrace();
    }
    return response;
  }
}