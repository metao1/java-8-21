package com.metao.examples.designpatterns.mediator;

import com.metao.examples.designpatterns.dp.mediator.User;

public class MediatorPatternDemo {
   public static void main(String[] args) {
      com.metao.examples.designpatterns.dp.mediator.User robert = new com.metao.examples.designpatterns.dp.mediator.User("Robert");
      com.metao.examples.designpatterns.dp.mediator.User john = new User("John");

      robert.sendMessage("Hi! John!");
      john.sendMessage("Hello! Robert!");
   }
}
