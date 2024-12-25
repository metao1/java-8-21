package com.metao.examples.designpatterns.saga.orchestration;

public class SagaApplication {

  /**
   * method to show common saga logic.
   */
  public static void main(String[] args) {
    var sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());

    com.metao.examples.designpatterns.saga.orchestration.Saga.Result goodOrder = sagaOrchestrator.execute("good_order");
    com.metao.examples.designpatterns.saga.orchestration.Saga.Result badOrder = sagaOrchestrator.execute("bad_order");
    com.metao.examples.designpatterns.saga.orchestration.Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

    System.out.printf("orders: goodOrder is %s, badOrder is %s,crashedOrder is %s%n",
            goodOrder, badOrder, crashedOrder);
  }


  private static com.metao.examples.designpatterns.saga.orchestration.Saga newSaga() {
    return Saga
            .create()
            .chapter("init an order")
            .chapter("booking a Fly")
            .chapter("booking a Hotel")
            .chapter("withdrawing Money");
  }

  private static ServiceDiscoveryService serviceDiscovery() {
    return new ServiceDiscoveryService()
            .discover(new OrderService())
            .discover(new HotelBookingService())
            .discover(new WithdrawMoneyService())
            .discover(new FlyBookingService());
  }
}
