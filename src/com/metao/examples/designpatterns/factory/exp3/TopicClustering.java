package com.metao.examples.designpatterns.factory.exp3;

import com.metao.examples.designpatterns.factory.exp3.Recommendation;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TopicClustering implements com.metao.examples.designpatterns.factory.exp3.Recommendation {


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