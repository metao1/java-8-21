package com.metao.examples.designpatterns.saga.choreography;

public class WithdrawMoneyService extends Service {

  public WithdrawMoneyService(ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "withdrawing Money";
  }

  @Override
  public com.metao.examples.designpatterns.saga.choreography.Saga process(com.metao.examples.designpatterns.saga.choreography.Saga saga) {
    var inValue = saga.getCurrentValue();

    if (inValue.equals("bad_order")) {
      System.out.printf("The chapter '%s', val '%s' has been started. But the exception has been raised."
              + "The rollback is about to start%n", getName(), inValue);
      saga.setCurrentStatus(Saga.ChapterResult.ROLLBACK);
      return saga;
    }
    return super.process(saga);
  }
}
