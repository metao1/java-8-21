package com.metao.java8.designpatterns.dp.adapter.exp2;

public class MediaProcessorDemo {

    public static void main(String[] args) {
        Article article = new ArticleContentManagement("The media to be processed");
        Media media = new MediaProcessorAdapter(article);
        Article article2 = new ArticleContentManagement("Another media to be processed");
        Media media2 = new MediaProcessorAdapter(article2);
        System.out.println(media.processMedia().length);
        System.out.println(media2.processMedia().length);
    }
}
