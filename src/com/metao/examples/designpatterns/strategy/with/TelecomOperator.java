package com.metao.examples.designpatterns.strategy.with;

public class TelecomOperator {
    private com.metao.examples.designpatterns.strategy.with.PlanStrategy plan;

    public void activatePlan (PlanStrategy strategy) {
        this.plan = strategy;
    }

    public int getFreeSMS() {
        return plan.getFreeSMS();
    }

    public int getFreeTalkTime() {
        return plan.getTalkTime();
    }
}