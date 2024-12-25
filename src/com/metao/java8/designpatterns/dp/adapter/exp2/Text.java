package com.metao.java8.designpatterns.dp.adapter.exp2;

public class Text implements AdapteeMedia{

        private final String content;
        
        Text(String content){
                this.content  =content;
        }
        
        @Override
        public String getContent() {
                return content;
        }
        
}
