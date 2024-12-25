package com.metao.java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ChainProcessor {

    static class ListValidator implements Valid, Condition<List<Integer>> {
        @Override
        public void validate(List<Integer> list) {
            if (test(list)) {
                throw new IllegalArgumentException("List is null or empty");
            }
        }

        @Override
        public boolean test(List<Integer> i) {
            return Collections.emptyList().equals(i);
        }
    }

    interface Condition<T> {
        boolean test(T i);
    }

    static class ItemsValidator extends Validator implements Condition<Integer> {
        private final Supplier<Integer> supplier;

        public ItemsValidator(Supplier<Integer> supplier, Valid validator) {
            super(validator);
            this.supplier = supplier;
        }

        @Override
        public void validate(List<Integer> list) {
            super.validate(list);
            if (test(list.size())) {
                throw new IllegalArgumentException("Invalid list size, expected " + supplier.get());
            }
        }

        @Override
        public boolean test(Integer i) {
            return supplier.get() < i;
        }
    }

    interface BiFunction<T extends Collection<? extends Number>, U extends Integer> {
        T apply(T t, U u);
    }

    static class NumberOperator implements Processor<List<Integer>, Set<Integer>> {

        private final BinaryOperator<Integer> consumer;

        public NumberOperator(BinaryOperator<Integer> consumer) {
            this.consumer = consumer;
        }

        @Override
        public void transfer(List<Integer> list, Set<Integer> collection) {
            Integer temp = null;
            if (!(list == null || list.isEmpty())) {
                temp = list.get(0);
                boolean passed = true;
                for (Integer item : list) {
                    if (passed) {
                        passed = false;
                        continue;
                    }
                    temp = consumer.apply(temp, item);
                }
            }
            Optional.ofNullable(temp).ifPresent(collection::add);
        }
    }

    static abstract class Validator implements Valid {
        final Valid validator;

        public Validator(Valid validator) {
            this.validator = validator;
        }

        @Override
        public void validate(List<Integer> list) {
            validator.validate(list);
        }
    }

    interface Valid {
        void validate(List<Integer> list);
    }

    interface Processor<I, O extends Collection> {
        void transfer(I input, O output);
    }

    static class ItemProcessor {
        private final List<Task> taskList = new LinkedList<>();
        private final Set<Integer> result = new LinkedHashSet<>();
        private final List<Integer> items;

        private ItemProcessor(List<Integer> items) {
            this.items = items;
        }

        ItemProcessor addOperator(Processor<List<Integer>, Set<Integer>> processor) {
            taskList.add(new ProcessorRunner(processor, result));
            return this;
        }

        ItemProcessor addValidator(Valid validator) {
            taskList.add(new ValidatorRunner(validator));
            return this;
        }

        static ItemProcessor of(List<Integer> items) {
            int[] arr = new int[items == null ? 0 : items.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = items.get(i);
            }
            return builder(arr);
        }

        static ItemProcessor builder(int... items) {
            List<Integer> emptyList = new LinkedList<>();
            for (int item : items) {
                emptyList.add(item);
            }
            return new ItemProcessor(emptyList);
        }

        ItemProcessor filter(Predicate<Integer> filter) {
            this.taskList.add(new FilterRunner(filter));
            return this;
        }

        void process(Processor<List<Integer>, Set<Integer>> sink) {
            taskList.forEach(Task::run);
            sink.transfer(items, result);
        }

        private void filtered(List<Integer> arr, Predicate<Integer> filter) {
            arr.removeIf(Predicate.not(filter));
        }

        class ProcessorRunner implements Task {

            private final Processor<List<Integer>, Set<Integer>> processor;
            private final Set<Integer> resultSet;

            ProcessorRunner(Processor<List<Integer>, Set<Integer>> processor, Set<Integer> resultSet) {
                this.processor = processor;
                this.resultSet = resultSet;
            }

            @Override
            public void run() {
                processor.transfer(items, resultSet);
            }
        }

        class ValidatorRunner implements Task {
            private final Valid validator;

            public ValidatorRunner(Valid validator) {
                this.validator = validator;
            }

            @Override
            public void run() {
                validator.validate(items);
            }
        }

        class FilterRunner implements Task {

            private final Predicate<Integer> filter;

            FilterRunner(Predicate<Integer> filter) {
                this.filter = filter;
            }

            @Override
            public void run() {
                filtered(items, filter);
            }
        }

        interface Task {
            void run();
        }
    }

    public static void main(String[] args) {
        test();
        testListValidatorPasses();
    }

    static void testListValidatorPasses() {
        var validator = new ListValidator();
        ItemProcessor.builder(1, 2, 3)
                .addValidator(validator)
                .process((input, output) -> {
                    assert input.size() == 3;
                    assert output.size() == 0;
                });
    }

    static void test() {
        final int MAX_ALLOWED_ITEMS = Integer.MAX_VALUE;
        List<Integer> items = List.of(1, 4, 5);

        var validator = new ItemsValidator(() -> MAX_ALLOWED_ITEMS, new ListValidator());
        var sumOperator = new NumberOperator(Integer::sum);
        var multiplexerOperator = new NumberOperator((a, b) -> a * b);
        var subtractOperator = new NumberOperator(Math::subtractExact);

        ItemProcessor.of(items)
                .addValidator(validator)
                .addOperator(sumOperator)
                .addOperator(multiplexerOperator)
                .process((input, output) -> {
                    assert input.size() == 3;
                    assert output.size() == 2;
                    assert output.contains(10);
                    assert output.contains(20);
                    System.out.println("item was " + input + ", and transferred to " + output);
                });

    }

}
