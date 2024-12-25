package com.metao.examples;

import java.util.List;
import java.util.function.BinaryOperator;

public class DecoratorIfs {

    static class ListValidator implements Valid {
        @Override
        public boolean validate(List<Integer> list) {
            return list != null && !list.isEmpty();
        }
    }

    static class ItemsValidator extends Validator {

        public ItemsValidator(Valid validator) {
            super(validator);
        }

        @Override
        public boolean validate(List<Integer> list) {
            return super.validate(list) && list.size() == 2;
        }
    }

    public static void main(String[] args) {
        List<Integer> items = List.of(1, 2);
        var validator = new SumValidator(Integer::sum, new ItemsValidator(new ListValidator()));
        System.out.println(validator.validate(items));
    }

    static class SumValidator extends Validator {

        private final BinaryOperator<Integer> consumer;

        public SumValidator(BinaryOperator<Integer> consumer, Valid validator) {
            super(validator);
            this.consumer = consumer;
        }

        @Override
        public boolean validate(List<Integer> list) {
            return super.validate(list) && list.stream().reduce(consumer).orElse(0) > 0;
        }
    }

    static abstract class Validator implements Valid {
        final Valid validator;

        public Validator(Valid validator) {
            this.validator = validator;
        }

        @Override
        public boolean validate(List<Integer> list) {
            return validator.validate(list);
        }
    }

    interface Valid {
        boolean validate(List<Integer> list);
    }
}
