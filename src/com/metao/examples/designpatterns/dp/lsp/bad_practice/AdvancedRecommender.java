package com.metao.examples.designpatterns.dp.lsp.bad_practice;

public class AdvancedRecommender extends AbstractRecommender {

        @Override
        protected String suggest() {
                var model = super.suggest();
                return "advanced_recommender_" + model;
        }

        @Override
        String loadMetadata() {
                System.out.println("load metadata");
                return "advanced_metadata_";
        }

        @Override
        String loadData() {
                System.out.println("load data");
                return "advanced_data_";
        }
}
