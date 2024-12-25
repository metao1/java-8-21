package com.metao.examples.designpatterns.dp.factory.exp3;

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
