package com.metao.examples.designpatterns.factory.exp3;

import com.metao.examples.designpatterns.factory.exp3.AssetContentManagement;
import com.metao.examples.designpatterns.factory.exp3.ContentManagement;
import com.metao.examples.designpatterns.factory.exp3.FakeRecommender;
import com.metao.examples.designpatterns.factory.exp3.InArticleReco;
import com.metao.examples.designpatterns.factory.exp3.Recommendation;

class FakeInArticleRecoRender extends com.metao.examples.designpatterns.factory.exp3.InArticleReco {

        @Override
        protected com.metao.examples.designpatterns.factory.exp3.ContentManagement getContentManagement() {
            return new com.metao.examples.designpatterns.factory.exp3.AssetContentManagement();
        }

        @Override
        protected com.metao.examples.designpatterns.factory.exp3.Recommendation getReco() {
            return new com.metao.examples.designpatterns.factory.exp3.FakeRecommender();
        }
    }
