package com.metao.examples.designpatterns.strategy.with;

import com.metao.examples.designpatterns.dp.strategy.with.PlanStrategy;

public class TelecomOperator {
    private com.metao.examples.designpatterns.dp.strategy.with.PlanStrategy plan;

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