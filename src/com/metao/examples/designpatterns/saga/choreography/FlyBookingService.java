package com.metao.examples.designpatterns.saga.choreography;

import com.metao.examples.designpatterns.saga.choreography.Service;

public class FlyBookingService extends Service {
  public FlyBookingService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "booking a Fly";
  }
}
