package com.metao.examples.designpatterns.dp.adapter.exp2;

public class TargetContentManagement implements AdapteeMedia {

    private final AdapteeMedia media;

    public TargetContentManagement(AdapteeMedia media) {
        this.media = media;
    }

    @Override
    public String getContent() {
        return media.getContent();
    }
}
