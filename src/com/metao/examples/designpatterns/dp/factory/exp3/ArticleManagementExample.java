package com.metao.examples.designpatterns.dp.factory.exp3;

public class ArticleManagementExample {

    public static void main(String[] args) {
        InArticleReco realInArticleRecoRender = new RealInArticleRecoRender();
        InArticleReco fakeInArticleReco = new FakeInArticleRecoRender();

        String realRender = realInArticleRecoRender.renderArticle();
        String fakeRender = fakeInArticleReco.renderArticle();
        System.out.println(realRender);
        System.out.println(fakeRender);
    }

}
