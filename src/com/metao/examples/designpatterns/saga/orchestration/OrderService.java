package com.metao.examples.designpatterns.saga.orchestration;

import com.metao.examples.designpatterns.dp.saga.orchestration.ChapterResult;
import com.metao.examples.designpatterns.dp.saga.orchestration.Service;

public class OrderService extends Service<String> {
  @Override
  public String getName() {
    return "init an order";
  }

  @Override
  public ChapterResult<String> process(String value) {
    if (value.equals("bad_order") || value.equals("crashed_order")) {
      System.out.printf("The chapter '%s', val: '%s' has been started. But the exception has been raised."
              + "The rollback is about to start", getName(), value);
      return ChapterResult.failure(value);
    }
    return super.process(value);
  }
}
