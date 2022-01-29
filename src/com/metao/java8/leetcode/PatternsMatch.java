package com.metao.java8.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PatternsMatch {

    public static void main(String[] args) {

        boolean b = wordPattern("abba", "dog cat cat fish");
        boolean b1 = wordPattern("abba", "dog cat cat dog");
        boolean b2 = wordPattern("aaaa", "dog dog dog dog");
        boolean b3 = wordPattern("aaaa", "dog dog dog cat");
        boolean b4 = wordPattern("abab", "dog cat dog cat");
        boolean b5 = wordPattern("abba", "dog dog dog dog");
        boolean b6 = wordPattern("abaa", "dog cat cat cat");
        boolean b7 = wordPattern("abba", "dog dog dog dog");
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        int index = 0;
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(pattern.charAt(index))) {
                if (!map.get(pattern.charAt(index)).equals(word)) {
                    return false;
                }
            } else if (map.containsValue(word)) {
                return false;
            } else {
                map.put(pattern.charAt(index), word);
            }
            index++;
        }
        return true;
    }
}
