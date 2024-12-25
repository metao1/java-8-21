package com.metao.examples.designpatterns.lsp.good_practice;

import com.metao.examples.designpatterns.dp.lsp.good_practice.AdvancedRecommender;

public class ArticleProcessor {

        void buildMainPage(RecommenderInterface recommender) {
                var suggestion = recommender.call();
                System.out.println("-------------");
                System.out.println("welcome to main page!");
                System.out.println(suggestion);
                System.out.println("-------------");
        }

        public static void main(String[] args) {                
                new ArticleProcessor().buildMainPage(new AdvancedRecommender());//is fine!
                new ArticleProcessor().buildMainPage(new SimpleRecommender());// violates LSP!
        }
}
