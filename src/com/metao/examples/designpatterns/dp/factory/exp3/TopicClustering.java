package com.metao.examples.designpatterns.dp.factory.exp3;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TopicClustering implements Recommendation {


    @Override
    public List<String> onlineIds() {
        try {
            return restCallTopicClustering().get(20, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            return null;
        }
    }

    CompletableFuture<List<String>> restCallTopicClustering() {
        return CompletableFuture.supplyAsync(() -> List.of("9891787", "7896589"));
    }
}