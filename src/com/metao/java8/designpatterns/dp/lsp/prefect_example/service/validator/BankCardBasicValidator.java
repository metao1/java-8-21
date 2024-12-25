package com.metao.java8.designpatterns.dp.lsp.prefect_example.service.validator;

import java.util.Date;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.PaymentInstrumentInvalidException;

public class BankCardBasicValidator implements PaymentInstrumentValidator {
  String name;
  String cardNumber;
  String verificationCode;
  Date expiryDate;

  public BankCardBasicValidator(String name, String cardNumber, String verificationCode, Date expiryDate) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.verificationCode = verificationCode;
    this.expiryDate = expiryDate;
  }

  @Override
  public void validate() throws PaymentInstrumentInvalidException {
    // basic validation on name, expiryDate etc.
    if (name == null || name.isEmpty()) {
      throw new PaymentInstrumentInvalidException("Name is invalid");
    }
    // other basic validations
  }
}
