package com.metao.java8.designpatterns.dp.lsp.prefect_example.model;

public class PaymentGatewayResponse {
  String fingerprint;

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public String getFingerprint() {
    return fingerprint;
  }
}