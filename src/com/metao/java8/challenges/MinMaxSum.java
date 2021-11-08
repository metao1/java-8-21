package com.metao.java8.challenges;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MinMaxSum {

    public static void main(String[] args) throws ParseException {
        List<Integer> arr = List.of(5, 5, 5, 5, 5);
        int max = arr.stream().max(Comparator.naturalOrder()).get();
        int min = arr.stream().min(Comparator.naturalOrder()).get();

        long maxSum = arr.stream()
                .mapToLong(Long::valueOf)
                .filter(i -> i != max)
                .reduce(Long::sum)
                .orElse((long) (arr.size() - 1) * arr.get(0));

        long minSum = arr.stream()
                .mapToLong(Long::valueOf)
                .filter(i -> i != min)
                .reduce(Long::sum)
                .orElse((long) (arr.size() - 1) * arr.get(0));

        System.out.println(maxSum + " " + minSum);
    }
}
