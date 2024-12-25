package com.metao.examples.designpatterns.factory.exp3;

public class ArticleManagementExample {

    public static void main(String[] args) {
        com.metao.examples.designpatterns.factory.exp3.InArticleReco realInArticleRecoRender = new com.metao.examples.designpatterns.factory.exp3.RealInArticleRecoRender();
        com.metao.examples.designpatterns.factory.exp3.InArticleReco fakeInArticleReco = new com.metao.examples.designpatterns.factory.exp3.FakeInArticleRecoRender();

        String realRender = realInArticleRecoRender.renderArticle();
        String fakeRender = fakeInArticleReco.renderArticle();
        System.out.println(realRender);
        System.out.println(fakeRender);
    }

}
