package com.metao.examples.designpatterns.factory.exp3;

import com.metao.examples.designpatterns.factory.exp3.Recommendation;

import java.util.List;

class FakeRecommender implements com.metao.examples.designpatterns.factory.exp3.Recommendation {

        @Override
        public List<String> onlineIds() {
            return List.of("1234145", "5132231");
        }
    }
