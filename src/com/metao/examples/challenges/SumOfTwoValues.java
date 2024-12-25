package com.metao.examples.challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SumOfTwoValues {

    public static void main(String[] args) {
        List<Number> numbers = List.of(1, 2, 3, 5, 6, 9, 8, 10, 7, 4);
        method1(numbers);
        method2(numbers);
        method3(numbers);

    }

    private static void method3(List<Number> numbers) {
        int val = 6;
        Set<Integer> foundValues = new HashSet<>();
        int num1 = 0, num2 = 0;
        for (Number number : numbers) {
            int num = number.intValue();
            if (foundValues.contains(val - num)) {
                num2 = num;
                num1 = val - num2;
                break;
            }
            foundValues.add(num);
        }
        System.out.println(num1 + "," + num2);
    }

    private static void method2(List<Number> numbers) {
        int val = 6;
        Map<Integer, Integer> map = new HashMap<>();
        for (Number number : numbers) {
            int num = number.intValue();
            map.put(num, val - num);
        }
        int num1 = 0, num2 = 0;
        for (Number number : numbers) {
            int num = number.intValue();
            if (map.get(num) + num == val) {
                num1 = map.get(num);
                num2 = num;
                break;
            }
        }
        System.out.println(num1 + "," + num2);
    }

    private static void method1(List<Number> numbers) {
        int val = 6;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                num1 = numbers.get(i).intValue();
                num2 = numbers.get(j).intValue();
                if (num1 + num2 == val) {
                    break;
                } else {
                    num1 = 0;
                    num2 = 0;
                }
            }
            if (num1 > 0 && num2 > 0) {
                break;
            }
        }
        System.out.println(num1 + "," + num2);
    }
}
