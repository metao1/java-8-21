package com.metao.java8.code;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConventionalProgramming {

    public static void main(String[] args) {
        List<Integer> ages = List.of(10, 12, 14, 20, 40);
        List<String> names = List.of("Angela", "Mehrdad", "Natalia", "James", "Firas");
        ConventionalProgramming conventionalProgramming = new ConventionalProgramming();
        //conventionalProgramming.calculateAge(ages, names);
        //conventionalProgramming.newWayInJava8(ages, names);
        conventionalProgramming.newWayOfThreading(ages);
    }

    public void calculateAge(List<Integer> ages, List<String> names) {
        //conventional way
        int sum = 0;
        for (Integer age : ages) {
            sum += age;
        }
        System.out.println("average age is: " + sum / ages.size());
    }

    public void newWayInJava8(List<Integer> ages) {
        ages.stream()
                .map(age -> "Age is: " + age + 1)
                .forEach(System.out::println);
    }
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void newWayOfThreading(List<Integer> ages) {
        MyInterface myInterface = (age, name) -> {
            return age + ":" + name;
        };

        AnotherInterface anInterface = new AnotherInterface() {
            @Override
            public String process(Integer age) {
                return null;
            }

            @Override
            public String processAnother(String name) {
                return null;
            }
        };

        MyInterface myInterface2 = (age, name) -> {
            return name + ":" + age;
        };

        for (Integer age : ages) {
            String result = myInterface2.process(age, "Angela");
            System.out.println(result);
        }
    }

    private class OneExample implements MyInterface {

        @Override
        public String process(Integer age, String name) {
            return "";
        }
    }

    interface AnotherInterface {
        String process(Integer age);
        String processAnother(String name);
    }

    interface MyInterface {
        public String process(Integer age, String name);
    }

    public void calculateAge(Integer age) {
        //heavy process
    }
}
