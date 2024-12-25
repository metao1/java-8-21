package com.metao.java8.designpatterns.dp.factory.exp3;

class FakeInArticleRecoRender extends InArticleReco {

        @Override
        protected ContentManagement getContentManagement() {
            return new AssetContentManagement();
        }

        @Override
        protected Recommendation getReco() {
            return new FakeRecommender();
        }
    }
