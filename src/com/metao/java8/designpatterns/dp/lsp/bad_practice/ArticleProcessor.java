package com.metao.java8.designpatterns.dp.lsp.bad_practice;

public class ArticleProcessor {

        void buildMainPage(AbstractRecommender recommender) {
                var suggestion = recommender.suggest();
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
