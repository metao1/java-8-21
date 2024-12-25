package com.metao.examples.designpatterns.lsp.prefect_example.service;

import com.metao.examples.designpatterns.dp.lsp.prefect_example.exception.FraudDetectedException;

public interface FraudChecker {
  void runChecks() throws FraudDetectedException;
}