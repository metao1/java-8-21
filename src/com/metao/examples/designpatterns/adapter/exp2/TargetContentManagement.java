package com.metao.examples.designpatterns.adapter.exp2;

public class TargetContentManagement implements com.metao.examples.designpatterns.adapter.exp2.AdapteeMedia {

    private final com.metao.examples.designpatterns.adapter.exp2.AdapteeMedia media;

    public TargetContentManagement(AdapteeMedia media) {
        this.media = media;
    }

    @Override
    public String getContent() {
        return media.getContent();
    }
}
