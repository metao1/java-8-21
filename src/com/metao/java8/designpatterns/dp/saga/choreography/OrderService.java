package com.metao.java8.designpatterns.dp.saga.choreography;

public class OrderService extends Service {

  public OrderService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "init an order";
  }
}
