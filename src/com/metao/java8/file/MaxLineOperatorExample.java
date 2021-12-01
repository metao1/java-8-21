package com.metao.java8.file;

import java.io.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxLineOperatorExample {

    public static void main(String[] args) {
        new MaxLineOperatorExample();
    }

    public MaxLineOperatorExample() {
        try (InputStream inputStream = new FileInputStream("merge-two-lists.txt")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String LongestLine = bufferedReader.lines()
                    .parallel()
                    .max(Comparator.comparingInt(String::length))
                    .orElse("");
            System.out.println(LongestLine);
            record Node(int value, Node next) {
            }

            Double average = Stream.of(1, 2, 3, 4)
                    .collect(Collectors.teeing(Collectors.summingDouble(i -> i), Collectors.counting(), (sum, n) -> sum / n));

            System.out.println(average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
