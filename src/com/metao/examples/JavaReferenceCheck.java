package com.metao.examples;

import java.util.List;
import java.util.stream.IntStream;

public class JavaReferenceCheck {

    public static void main(String[] args) {
        List<Item> items = IntStream.range(0, 10)
                .boxed()
                .map(Item::new)
                .toList();
        Item item = items.get(1);
        item.setNumber(2);
        System.out.println(items);
    }

    private static class Item {
        int number;

        public Item(Integer i) {
            this.number = i;
        }

        void setNumber(int i) {
            this.number = i;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "number=" + number +
                    '}';
        }
    }
}
