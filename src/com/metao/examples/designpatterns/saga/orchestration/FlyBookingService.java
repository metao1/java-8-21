package com.metao.examples.designpatterns.saga.orchestration;

import com.metao.examples.designpatterns.saga.orchestration.Service;

public class FlyBookingService extends Service<String> {
  @Override
  public String getName() {
    return "booking a Fly";
  }
}
