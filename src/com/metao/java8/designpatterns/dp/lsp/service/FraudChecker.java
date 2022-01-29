package com.metao.java8.designpatterns.dp.lsp.service;

import com.metao.java8.designpatterns.dp.lsp.exception.FraudDetectedException;

public interface FraudChecker {
  void runChecks() throws FraudDetectedException;
}