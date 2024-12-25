package com.metao.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NestedIfs {

    public Item validateItemsAndReturn(List<Item> list) {
        if (list != null && list.size() == 2) {
            Item item1 = list.get(0);
            Item item2 = list.get(1);
            if (item1 != null && item2 != null) {
                int sum = item1.i + item2.i;
                if (sum > 0) {
                    if (sum >> 2 == 0) {
                        return new Item(sum);
                    }
                }
            }
        }
        return null;
    }

    record Item(Integer i) {

    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>() {{
            add(new Item(1));
            add(new Item(2));
        }};
        List<Validator> validators  = new LinkedList<>();
        validators.add(new ListValidator());
        validators.add(new ItemsValidator());
        validators.add(new SumValidator());
        validators.add(new ShiftValidator());
        boolean condition =false;
        for (Validator validator : validators) {
            condition = validator.validate(items);
        }
        if(condition) {
            //logic
        }
    }

    static class ShiftValidator implements Validator {
        @Override
        public boolean validate(List<Item> item) {
            return item.get(0).i + item.get(1).i >> 2 == 0;
        }
    }

    static class SumValidator implements Validator {

        @Override
        public boolean validate(List<Item> item) {
            return item.get(0).i + item.get(1).i > 0;
        }
    }

     static class ItemsValidator implements Validator {

        @Override
        public boolean validate(List<Item> item) {
            Item item1 = item.get(0);
            Item item2 = item.get(1);
            return item1 != null && item2 != null;
        }
    }

     static class ListValidator implements Validator {

        @Override
        public boolean validate(List<Item> item) {
            return item != null && item.size() == 2;
        }
    }


    interface Validator {
        boolean validate(final List<Item> list);
    }
}
