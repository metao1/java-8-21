package com.metao.java8.designpatterns.dp.lsp.good_practice;

public class SimpleRecommender implements RecommenderInterface {

        @Override
        public String call() {
                return "simple_recommended";
        }

}
