package com.metao.examples.designpatterns.iterator;

import com.metao.examples.designpatterns.iterator.Container;
import com.metao.examples.designpatterns.iterator.Iterator;

public class NameRepository implements Container {
    public String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public com.metao.examples.designpatterns.iterator.Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}