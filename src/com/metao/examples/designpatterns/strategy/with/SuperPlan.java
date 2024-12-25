package com.metao.examples.designpatterns.strategy.with;

public class SuperPlan implements PlanStrategy {
     public int getFreeSMS() {
        return 50;
     }

    public int getTalkTime() {
        return 60;
    }
}