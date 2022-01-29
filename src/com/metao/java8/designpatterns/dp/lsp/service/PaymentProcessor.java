package com.metao.java8.designpatterns.dp.lsp.service;

import com.metao.java8.designpatterns.dp.lsp.exception.PaymentInstrumentInvalidException;
import com.metao.java8.designpatterns.dp.lsp.model.PaymentResponse;
import com.metao.java8.designpatterns.dp.lsp.exception.PaymentFailedException;
import com.metao.java8.designpatterns.dp.lsp.model.OrderDetails;

public class PaymentProcessor {
  public void process(OrderDetails orderDetails, PaymentInstrument paymentInstrument) {
    try {
      paymentInstrument.validate();
      PaymentResponse response = paymentInstrument.collectPayment();
      saveToDatabase(orderDetails, response.getIdentifier());
    } catch (PaymentInstrumentInvalidException | PaymentFailedException e) {
      // exception handling
    }
  }

  void saveToDatabase(OrderDetails orderDetails, String identifier) {
    // save the identifier and order details in DB
  }
}