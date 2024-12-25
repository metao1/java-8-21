package com.metao.examples.designpatterns.dp.lsp.good_practice;

public class SimpleRecommender implements RecommenderInterface {

        @Override
        public String call() {
                return "simple_recommended";
        }

}
