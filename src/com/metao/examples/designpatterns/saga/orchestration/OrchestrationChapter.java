package com.metao.examples.designpatterns.saga.orchestration;

import com.metao.examples.designpatterns.saga.orchestration.ChapterResult;

/**
 * OrchestrationChapter is an interface representing a contract for an external service.
 *
 * @param <K> is type for passing params
 */
public interface OrchestrationChapter<K> {

    /**
     * method get name.
     *
     * @return service name.
     */
    String getName();

    /**
     * The operation executed in general case.
     *
     * @param value incoming value
     * @return result {@link com.metao.examples.designpatterns.saga.orchestration.ChapterResult}
     */
    com.metao.examples.designpatterns.saga.orchestration.ChapterResult<K> process(K value);

    /**
     * The operation executed in rollback case.
     *
     * @param value incoming value
     * @return result {@link com.metao.examples.designpatterns.saga.orchestration.ChapterResult}
     */
    ChapterResult<K> rollback(K value);
}