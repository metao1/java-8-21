package com.metao.java8.designpatterns.dp.adapter.exp2;

public class ArticleContentManagement implements Article {

    private final String content;

    public ArticleContentManagement(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
