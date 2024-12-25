package com.metao.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountWords {

    public static void main(String[] args) {
        String[] blockedWords = new String[]{"the"};
        List<String> blockedList = Arrays.asList(blockedWords);
        String paragraph = "The ball, hit elephant and BALL caused it to die.";
        String cleanedPar = paragraph.replaceAll("\\W+", " ");
        //or String cleanedPar = paragraph.replaceAll("[^a-zA-Z0-9]+", " ");
        // Find max occurrence word in paragraph
        String key = Arrays.stream(cleanedPar.split(" "))
                .map(String::toLowerCase)
                .filter(Predicate.not(blockedList::contains))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        // Find max occurrence words in paragraph reversed sorted by occurrence as list of values
        var item = Arrays.stream(cleanedPar.split("\\s+"))
                .map(String::toLowerCase)
                .filter(Predicate.not(blockedList::contains))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        System.out.println(item);
    }
}
