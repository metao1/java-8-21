package com.metao.java8;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Spliterator.CONCURRENT;
import static java.util.Spliterator.NONNULL;

public class CountReputationOfWordsInParagraph {

    public static void main(String[] args) {
        String p = "The best solution to this algo, is. to count , the number of word reputation.and also" +
                ",for this we have many options and the way we solve it can be efficient or simple, depends on the " +
                "word length and method we need to use.";
        StringBuilder sb = new StringBuilder(p);
        sb.append(String.valueOf(sb).repeat(100000));
        countWordsMethod(sb.toString());
    }

    private static void countWordsMethod(String p) {
        long startTime = System.currentTimeMillis();
        final int method1 = method1(p);
        System.out.println("method1 delay: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        /**
         *          * Commented out because of huge under performance
        final int method3 = method3(p);
        System.out.println("method3 delay: " + (System.currentTimeMillis() - startTime)+ "ms");
        startTime = System.currentTimeMillis();
         */
        final int method4 = method4(p);
        System.out.println("method4 delay: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        /**
         *          * Commented out because of huge under performance
        final int method5 = method5(p);
        System.out.println("method5 delay: " + (System.currentTimeMillis() - startTime)+ "ms");
        startTime = System.currentTimeMillis();
         */
        final int method6 = method6(p);
        System.out.println("method6 delay: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        final int method7 = method7(p);
        System.out.println("method7 delay: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        final int method8 = method8(p);
        System.out.println("method8 delay: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        final int method9 = method9(p);
        System.out.println("method9 delay: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * using Stream grouping helper functions
     */
    private static int method9(String p) {
        p = p.replaceAll("[.|,]", "\s");
        final String[] words = p.split("\s+");
        final int totalGroups = Stream.of(words)
                .parallel()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet()
                .size();
        return words.length - totalGroups;
    }

    /**
     * using StringBuffer and ForkJoin
     */
    private static int method8(String p) {
        p = p.replaceAll("[.|,]", "\s");
        final StringBuffer sb = new StringBuffer(p);
        final int threadCount = 6;
        List<CompletableFuture<Integer>> threads = new LinkedList<>();
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < threadCount; i++) {
            String s = sb.subSequence(i * sb.length() / threadCount, (i + 1) * sb.length() / threadCount).toString();
            threads.add(CompletableFuture.supplyAsync(() -> {
                String[] words = s.split("\s+");
                for (String word : words) {
                    map.merge(word.toLowerCase(), 1, Integer::sum);
                }
                return words.length;
            }));
        }
        return threads.stream()
                .parallel()
                .map(CompletableFuture::join)
                .reduce(Integer::sum)
                .get() - map.values().size();
    }

    /**
     * using Java Streams functional programming
     */
    private static int method7(String p) {
        p = p.replaceAll("[.|,]", "\s");
        final String[] words = p.split("\s+");
        final int totalGroups = Stream.of(words)
                .parallel()
                .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum))
                .keySet()
                .size();
        return words.length - totalGroups;
    }

    class Note implements Comparable<Note>{

        @Override
        public int compareTo(Note o) {
            return 0;
        }
    }

    /**
     * using Spliterators and parallelize methods
     */
    private static int method6(String p) {
        p = p.replaceAll("[.|,]", "\s");
        Map<String, Integer> map = new ConcurrentHashMap<>();
        Map<Integer, Integer> collect = Arrays.stream(new int[]{})
                .flatMap(IntStream::of)
                .boxed()
                .collect(Collectors.toMap(integer -> integer, Function.identity()));
        final String[] words = p.split("\s+");
        StreamSupport.stream(Spliterators.spliterator(words, CONCURRENT | NONNULL), true)
                .forEach((a -> map.merge(((String) a).toLowerCase(), 1, Integer::sum)));
        int sum = words.length - map.keySet().size();
        return sum;
    }

    /**
     * using classic for-loop without extra data structure
     */
    private static int method5(String p) {
        int start = -1, end = 0, wordCount = 0;
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < p.toCharArray().length; i++) {
            if (Character.isLetter(p.charAt(i))) {
                if (start == -1) {
                    start = i;
                } else if (end != 0) {
                    String word = p.substring(start, end);
                    map.merge(word, 1, Integer::sum);
                    start = i;
                    end = 0;
                    wordCount++;
                }
            } else if (!Character.isLetter(p.charAt(i))) {
                if (end == 0) {
                    end = i;
                }
            }
        }
        wordCount++;
        int sum = wordCount - map.keySet().size();
        return sum;
    }

    /**
     * using StringReader
     */
    private static int method4(String p) {
        int sum = 0;
        try (final BufferedReader br = new BufferedReader(new StringReader(p))) {
            final String sentence = br.readLine();
            sum += method1(sentence);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return sum;
    }

    /**
     * using StringBuilder
     */
    private static int method3(String p) {
        final StringBuilder sb = new StringBuilder(p);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < sb.toString().toCharArray().length; i++) {
            if (sb.charAt(i) == ',') {
                sb.deleteCharAt(i);
                sb.insert(i, "\s");
            } else if (sb.charAt(i) == '.') {
                sb.deleteCharAt(i);
                sb.insert(i, "\s");
            }

        }
        String[] words = sb.toString().split("\s+");
        for (String word : words) {
            map.merge(word.toLowerCase(), 1, Integer::sum);
        }
        final int sum = words.length - map.values().size();
        return sum;
    }

    /**
     * using classic for-loop and help of other structure like HashMap
     */
    private static int method1(String p) {
        p = p.replaceAll("[.|,]", "\s");
        Map<String, Integer> map = new HashMap<>();
        String[] words = p.split("\s+");
        for (String word : words) {
            map.merge(word.toLowerCase(), 1, Integer::sum);
        }
        final int sum = words.length - map.values().size();
        return sum;
    }
}
