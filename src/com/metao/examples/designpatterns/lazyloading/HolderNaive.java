package com.metao.examples.designpatterns.lazyloading;

import com.metao.examples.designpatterns.dp.lazyloading.Heavy;

public class HolderNaive {

    private com.metao.examples.designpatterns.dp.lazyloading.Heavy heavy;

    public HolderNaive() {
        System.out.println("HolderNaive created");
    }

    /**
     * Get heavy object.
     */
    public com.metao.examples.designpatterns.dp.lazyloading.Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}