package com.metao.java8.hackerrank.business;

import java.util.*;
import java.util.stream.Collectors;

public class LoveCounter {
    static class Love {
        String receiver;
        String sender;
        String message;

        Love(String receiver, String sender, String message) {
            this.message = message;
            this.receiver = receiver;
            this.sender = sender;
        }

        String getSender() {
            return sender;
        }

        String getReceiver() {
            return receiver;
        }
    }

    static Love[] loves = new Love[]{
            new Love("mehrdad@example.com", "ali@example.com", "Hello and thanks"),
            new Love("mohammad@example.com", "ali@example.com", "Hello and thanks"),
            new Love("mehdi@example.com", "ali@example.com", "Hello and thanks"),
            new Love("mehdi@example.com", "shadi@example.com", "Hello and thanks"),
            new Love("mehrdad@example.com", "shadi@example.com", "Hello and thanks"),
            new Love("shadi@example.com", "mehrdad@example.com", "Hello and thanks"),
            new Love("ali@example.com", "mehrdad@example.com", "Hello and thanks")
    };

    public static void main(String[] args) {
        Arrays.stream(loves)
                //.collect(Collectors.groupingBy(Love::getReceiver, Collectors.summingInt(e -> 1)))
                //.collect(Collectors.groupingBy(Love::getReceiver, Collectors.counting()))
                .collect(Collectors.toConcurrentMap(Love::getReceiver, w -> 1, Integer::sum))
                //.collect(Collectors.toMap(Love::getReceiver, Love::getReceiver, (v1, v2) -> v1, LinkedHashMap::new))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        //only save the first incident in map
        HashMap<String, String> collect = Arrays.stream(loves)
                .collect(Collectors.toMap(Love::getReceiver, Love::getSender, (v1, v2) -> v1, HashMap::new));

        System.out.println("collect = " + collect);

    }


}
