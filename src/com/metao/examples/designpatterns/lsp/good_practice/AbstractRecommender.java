package com.metao.examples.designpatterns.lsp.good_practice;

public abstract class AbstractRecommender implements RecommenderInterface {

        protected String suggest() {        
                var data = loadData();
                var metadata = loadMetadata();
                return calculateModel(data, metadata);                
        }

        private String calculateModel(String data, String metadata) {
                return "calculated_".concat(data).concat(metadata);
        }

        public String call() {
                return suggest();
        }

        abstract String loadMetadata();

        abstract String loadData();        

}
