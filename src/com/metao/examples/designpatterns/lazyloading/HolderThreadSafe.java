package com.metao.examples.designpatterns.lazyloading;

import com.metao.examples.designpatterns.dp.lazyloading.Heavy;

public class HolderThreadSafe {

  private com.metao.examples.designpatterns.dp.lazyloading.Heavy heavy;

  /**
   * Constructor.
   */
  public HolderThreadSafe() {
    System.out.println("HolderThreadSafe created");
  }

  /**
   * Get heavy object.
   */
  public synchronized com.metao.examples.designpatterns.dp.lazyloading.Heavy getHeavy() {
    if (heavy == null) {
      heavy = new Heavy();
    }
    return heavy;
  }
}