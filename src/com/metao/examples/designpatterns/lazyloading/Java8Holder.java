package com.metao.examples.designpatterns.lazyloading;

import com.metao.examples.designpatterns.dp.lazyloading.Heavy;

import java.util.function.Supplier;

public class Java8Holder {


  private Supplier<com.metao.examples.designpatterns.dp.lazyloading.Heavy> heavy = this::createAndCacheHeavy;

  public Java8Holder() {
    System.out.println("Java8Holder created");
  }

  public com.metao.examples.designpatterns.dp.lazyloading.Heavy getHeavy() {
    return heavy.get();
  }

  private synchronized com.metao.examples.designpatterns.dp.lazyloading.Heavy createAndCacheHeavy() {
    class HeavyFactory implements Supplier<com.metao.examples.designpatterns.dp.lazyloading.Heavy> {
      private final com.metao.examples.designpatterns.dp.lazyloading.Heavy heavyInstance = new com.metao.examples.designpatterns.dp.lazyloading.Heavy();

      @Override
      public Heavy get() {
        return heavyInstance;
      }
    }

    if (!(heavy instanceof HeavyFactory)) {
      heavy = new HeavyFactory();
    }

    return heavy.get();
  }
}
