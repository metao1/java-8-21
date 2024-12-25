package com.metao.examples.designpatterns.mediator;

public class MediatorPatternDemo {
   public static void main(String[] args) {
      com.metao.examples.designpatterns.mediator.User robert = new com.metao.examples.designpatterns.mediator.User("Robert");
      com.metao.examples.designpatterns.mediator.User john = new User("John");

      robert.sendMessage("Hi! John!");
      john.sendMessage("Hello! Robert!");
   }
}
