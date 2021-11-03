package com.metao.java8.challenges;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanSegmentString {

    public static void main(String[] args) {
        Set<String> dic = new HashSet<>(List.of("apple", "pie", "pear", "pier"));
        System.out.println(canSegmentStringMethod1("applepeer", dic));
        System.out.println(canSegmentStringMethod2("applepie", dic));
    }

    private static boolean canSegmentStringMethod2(String s, Set<String> dic) {
        if (s == null) {
            return false;
        }
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (dic.contains(substring)) {
                return s.substring(i).length() == 0 || canSegmentStringMethod2(s.substring(i), dic);
            }
        }
        return false;
    }

    private static boolean canSegmentStringMethod1(String s, Set<String> dic) {
        if (s == null) {
            return false;
        }
        String foundItem = "";
        int counter = 0;
        while (s.length() > 0 && counter < s.length()) {
            foundItem += (s.charAt(counter));
            counter++;
            if (dic.contains(foundItem)) {
                s = s.substring(counter);
                counter = 0;
                foundItem = "";
            }
        }
        return s.length() == 0;
    }
}
