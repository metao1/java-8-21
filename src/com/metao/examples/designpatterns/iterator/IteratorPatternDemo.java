package com.metao.examples.designpatterns.iterator;

import com.metao.examples.designpatterns.dp.iterator.Iterator;
import com.metao.examples.designpatterns.dp.iterator.NameRepository;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        com.metao.examples.designpatterns.dp.iterator.NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}