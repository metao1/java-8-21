package com.metao.examples.designpatterns.saga.choreography;

public interface ChoreographyChapter {

  /**
   * In that case, every method is responsible to make a decision on what to do then.
   *
   * @param saga incoming saga
   * @return saga result
   */
  com.metao.examples.designpatterns.saga.choreography.Saga execute(com.metao.examples.designpatterns.saga.choreography.Saga saga);

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
   * @return result {@link com.metao.examples.designpatterns.saga.choreography.Saga}
   */
  com.metao.examples.designpatterns.saga.choreography.Saga process(com.metao.examples.designpatterns.saga.choreography.Saga saga);

  /**
   * The operation executed in rollback case.
   *
   * @param saga incoming saga
   * @return result {@link com.metao.examples.designpatterns.saga.choreography.Saga}
   */
  com.metao.examples.designpatterns.saga.choreography.Saga rollback(Saga saga);


}
