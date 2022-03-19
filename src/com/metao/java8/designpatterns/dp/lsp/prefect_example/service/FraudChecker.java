package com.metao.java8.designpatterns.dp.lsp.prefect_example.service;

import com.metao.java8.designpatterns.dp.lsp.prefect_example.exception.FraudDetectedException;

public interface FraudChecker {
  void runChecks() throws FraudDetectedException;
}