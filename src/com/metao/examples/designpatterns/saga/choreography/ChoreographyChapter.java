package com.metao.examples.designpatterns.saga.choreography;

import com.metao.examples.designpatterns.dp.saga.choreography.Saga;

public interface ChoreographyChapter {

  /**
   * In that case, every method is responsible to make a decision on what to do then.
   *
   * @param saga incoming saga
   * @return saga result
   */
  com.metao.examples.designpatterns.dp.saga.choreography.Saga execute(com.metao.examples.designpatterns.dp.saga.choreography.Saga saga);

  /**
   * get name method.
   *
   * @return service name.
   */
  String getName();

  /**
   * The operation executed in general case.
   *
   * @param saga incoming saga
   * @return result {@link com.metao.examples.designpatterns.dp.saga.choreography.Saga}
   */
  com.metao.examples.designpatterns.dp.saga.choreography.Saga process(com.metao.examples.designpatterns.dp.saga.choreography.Saga saga);

  /**
   * The operation executed in rollback case.
   *
   * @param saga incoming saga
   * @return result {@link com.metao.examples.designpatterns.dp.saga.choreography.Saga}
   */
  com.metao.examples.designpatterns.dp.saga.choreography.Saga rollback(Saga saga);


}
