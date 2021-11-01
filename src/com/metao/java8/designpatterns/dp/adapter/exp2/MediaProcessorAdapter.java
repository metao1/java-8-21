package com.metao.java8.designpatterns.dp.adapter.exp2;

import java.nio.charset.StandardCharsets;

public class MediaProcessorAdapter implements Media {

    private final Article article;

    public MediaProcessorAdapter(Article article) {
        this.article = article;
    }

    @Override
    public byte[] processMedia() {
        return article.getContent().getBytes(StandardCharsets.UTF_8);
    }
}
