package com.metao.examples;

import java.util.ArrayList;
import java.util.List;

public class LambdaLessFilterExample {

    interface Operators {
        boolean filter(Filter filter);

        long map(int b);

        Operators set(Integer num);
    }

    interface Filter {
        boolean filter(int a);
    }

    // unsafe type
    Operators filterOperator = new Operators() {
        public Integer a;

        @Override
        public boolean filter(Filter filter) {
            return filter.filter(a);
        }

        @Override
        public long map(int b) {
            return (long) b * 10000;
        }

        @Override
        public Operators set(Integer num) {
            this.a = num;
            return this;
        }
    };


    public LambdaLessFilterExample() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = new ArrayList<>();
        for (Integer num : list1) {
            boolean filtered = filterOperator
                    .set(num)
                    .filter(a -> a > 1);
            if (filtered) {
                list2.add(num);
            }
        }
        System.out.println(list2);
    }

    public static void main(String[] args) {
        new LambdaLessFilterExample();
    }
}
