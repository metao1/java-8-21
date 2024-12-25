package com.metao.examples.designpatterns.throtlling;

import com.metao.examples.designpatterns.throtlling.CallsCount;
import com.metao.examples.designpatterns.throtlling.Throttler;

import java.util.Timer;
import java.util.TimerTask;

public class ThrottleTimerImpl implements Throttler {

  private final int throttlePeriod;
  private final com.metao.examples.designpatterns.throtlling.CallsCount callsCount;

  public ThrottleTimerImpl(int throttlePeriod, CallsCount callsCount) {
    this.throttlePeriod = throttlePeriod;
    this.callsCount = callsCount;
  }

  @Override
  public void start() {
    new Timer(true).schedule(new TimerTask() {
      @Override
      public void run() {
        callsCount.reset();
      }
    }, 0, throttlePeriod);
  }
}

