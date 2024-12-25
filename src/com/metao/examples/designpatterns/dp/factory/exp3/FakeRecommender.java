package com.metao.examples.designpatterns.dp.factory.exp3;

import java.util.List;

class FakeRecommender implements Recommendation {

        @Override
        public List<String> onlineIds() {
            return List.of("1234145", "5132231");
        }
    }
