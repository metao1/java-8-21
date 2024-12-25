package com.metao.examples.designpatterns.lsp.prefect_example.service;

import com.metao.examples.designpatterns.lsp.prefect_example.exception.PaymentFailedException;
import com.metao.examples.designpatterns.lsp.prefect_example.exception.PaymentInstrumentInvalidException;
import com.metao.examples.designpatterns.lsp.prefect_example.model.OrderDetails;
import com.metao.examples.designpatterns.lsp.prefect_example.model.PaymentResponse;

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