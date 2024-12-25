package com.metao.examples.designpatterns.observer;

import com.metao.examples.designpatterns.dp.observer.Observer;

class Newspaper implements com.metao.examples.designpatterns.dp.observer.Observer {
       @Override
       public void update(float interest) {
              System.out.println("Newspaper: Interest Rate updated, new Rate is: "
                           + interest);
       }
}