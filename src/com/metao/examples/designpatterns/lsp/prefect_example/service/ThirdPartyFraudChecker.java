package com.metao.examples.designpatterns.lsp.prefect_example.service;

import java.util.Date;

import com.metao.examples.designpatterns.lsp.prefect_example.exception.FraudDetectedException;
import com.metao.examples.designpatterns.lsp.prefect_example.service.FraudChecker;
import com.metao.examples.designpatterns.lsp.prefect_example.service.ThirdPartyFraudDetectionSystem;

public class ThirdPartyFraudChecker implements FraudChecker {
  String name;
  String cardNumber;
  String verificationCode;
  Date expiryDate;

  ThirdPartyFraudDetectionSystem fraudDetection = new ThirdPartyFraudDetectionSystem();

  public ThirdPartyFraudChecker(String name, String cardNumber, String verificationCode, Date expiryDate) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.verificationCode = verificationCode;
    this.expiryDate = expiryDate;
  }

  @Override
  public void runChecks() throws FraudDetectedException {
    // run checks against a third-party system
    System.out.println("Running fraud checks against third-party system");
    fraudDetection.process(name, cardNumber, verificationCode, expiryDate);
    System.out.println("Fraud checks passed");

  }
}