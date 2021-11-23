package com.metao.java8.hackerrank;

import java.util.List;
import java.util.TreeSet;

public class NoPrefixSet {

    public static void main(String[] args) {
        List<String> list = List.of("aab", "defgab", "abcde", "aabcde", "cedaaa", "bbbbbbbbbb", "jabjjjad");
        noPrefix(list);
    }

    public static void noPrefix(List<String> words) {
        TreeSet<String> tree = new TreeSet<>();

        for (String word : words) {
            String next = tree.ceiling(word);
            String prev = tree.floor(word);

            if (next != null && next.startsWith(word) || prev != null && word.startsWith(prev)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
            tree.add(word);
        }
        System.out.println("GOOD SET");
    }
}
