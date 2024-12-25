package com.metao.examples.designpatterns.adapter.exp2;

import com.metao.examples.designpatterns.dp.adapter.exp2.Article;
import com.metao.examples.designpatterns.dp.adapter.exp2.TargetContentManagement;
import com.metao.examples.designpatterns.dp.adapter.exp2.Text;

public class MediaProcessorDemo {

    public static void main(String[] args) {
        var media1 = new TargetContentManagement(new Article("Article media to be processed"));
        var media2 = new TargetContentManagement(new Text("Text media to be processed"));
        System.out.println(media1.getContent());
        System.out.println(media2.getContent());
    }
}
