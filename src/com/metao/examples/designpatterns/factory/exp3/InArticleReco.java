package com.metao.examples.designpatterns.factory.exp3;

import com.metao.examples.designpatterns.dp.factory.exp3.Recommendation;

abstract class InArticleReco {

        public String renderArticle() {
            Recommendation recommendation = getReco();
            ContentManagement contentManagement = getContentManagement();
            return contentManagement.getContent(recommendation.onlineIds());
        }

        protected abstract ContentManagement getContentManagement();

        protected abstract Recommendation getReco();
    }
