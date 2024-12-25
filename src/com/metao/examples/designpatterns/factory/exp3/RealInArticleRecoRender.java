package com.metao.examples.designpatterns.factory.exp3;

class RealInArticleRecoRender extends com.metao.examples.designpatterns.factory.exp3.InArticleReco {

        @Override
        protected com.metao.examples.designpatterns.factory.exp3.ContentManagement getContentManagement() {
            return new com.metao.examples.designpatterns.factory.exp3.AssetContentManagement();
        }

        @Override
        protected com.metao.examples.designpatterns.factory.exp3.Recommendation getReco() {
            return new com.metao.examples.designpatterns.factory.exp3.TopicClustering();
        }
    }