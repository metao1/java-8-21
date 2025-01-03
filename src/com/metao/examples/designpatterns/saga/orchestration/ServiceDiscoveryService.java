package com.metao.examples.designpatterns.saga.orchestration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The class representing a service discovery pattern.
 */
public class ServiceDiscoveryService {
  private final Map<String, com.metao.examples.designpatterns.saga.orchestration.OrchestrationChapter<?>> services;

  public Optional<com.metao.examples.designpatterns.saga.orchestration.OrchestrationChapter> find(String service) {
    return Optional.ofNullable(services.getOrDefault(service, null));
  }

  public ServiceDiscoveryService discover(OrchestrationChapter<?> orchestrationChapterService) {
    services.put(orchestrationChapterService.getName(), orchestrationChapterService);
    return this;
  }

  public ServiceDiscoveryService() {
    this.services = new HashMap<>();
  }


}
