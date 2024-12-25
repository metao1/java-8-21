package com.metao.examples.designpatterns.dp.lsp.bad_practice;

public abstract class AbstractRecommender {

        protected String suggest() {
                var data = loadData();
                var metadata = loadMetadata();
                var model = calculateModel(data, metadata);
                return callRecommender(model);
        }

        private String callRecommender(String model) {
                return "recommending_".concat(model);
        }

        abstract String loadMetadata();

        abstract String loadData();

        private String calculateModel(String data, String metadata) {
                System.out.println("calculating model");
                if (metadata != null) { // one idea is to use if..else for resolve LSP, but this violates Open-Close
                                        // principal itself! also makes code unreadble and hard to maintain.
                        return metadata.concat("processed_with_").concat(data);
                } else if (metadata.length() < 3) {
                        return data.concat("_processed");
                }
                // another idea is to throw exception!
                // if another recommeder with new type of metadata comes we also violates LSP
                // since developer does not know
                // the reason for getting exception by default, only after debugging the code
                // wrote way to understand the metadata type
                throw new RuntimeException("data is too small!");
        }

}
