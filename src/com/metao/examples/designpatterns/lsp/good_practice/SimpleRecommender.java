package com.metao.examples.designpatterns.lsp.good_practice;

public class SimpleRecommender implements RecommenderInterface {

        @Override
        public String call() {
                return "simple_recommended";
        }

}
