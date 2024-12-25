package com.metao.examples.designpatterns.lsp.prefect_example.model;

public class PaymentGatewayResponse {
  String fingerprint;

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public String getFingerprint() {
    return fingerprint;
  }
}