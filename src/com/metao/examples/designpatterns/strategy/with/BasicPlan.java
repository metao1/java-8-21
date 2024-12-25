package com.metao.examples.designpatterns.strategy.with;

public class BasicPlan implements PlanStrategy {
    public int getFreeSMS() {
        return 25;
    }

    public int getTalkTime() {
        return 20;
    }
}