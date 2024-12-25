package com.metao.examples.designpatterns.lsp.good_practice;

import com.metao.examples.designpatterns.lsp.good_practice.AbstractRecommender;

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
