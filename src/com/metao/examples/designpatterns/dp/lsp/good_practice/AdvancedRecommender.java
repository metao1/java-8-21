package com.metao.examples.designpatterns.dp.lsp.good_practice;

public class AdvancedRecommender extends AbstractRecommender {

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
