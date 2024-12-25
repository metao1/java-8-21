package com.metao.examples.designpatterns.dp.lsp.bad_practice;

public class SimpleRecommender extends AbstractRecommender {

        @Override
        String loadData() {
                // I only need to load data nothing more!
                return "simple_data_";
        }

        @Override
        String loadMetadata() {
                // I forced to implement this method sorry!
                return null;
        }

}
