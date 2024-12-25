package com.metao.examples.designpatterns.adapter.exp2;

public class Article implements AdapteeMedia {
    private final String content;

    Article(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
