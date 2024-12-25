package com.metao.examples.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            Double average = Stream.of(1, 2, 3, 4)
                    .collect(Collectors.teeing(Collectors.summingDouble(i -> i), Collectors.counting(), (sum, n) -> sum / n));

            System.out.println(average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
