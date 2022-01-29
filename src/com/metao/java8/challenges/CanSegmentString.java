package com.metao.java8.challenges;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanSegmentString {

    public static void main(String[] args) {
        Set<String> dic = new HashSet<>(List.of("apple", "pie", "ab", "pear", "pier"));
        System.out.println(canSegmentStringMethod1("appleab", dic));
        System.out.println(canSegmentStringMethod2("appleabpear", dic));
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

    //works only for two segmented words
    private static boolean canSegmentStringMethod1(String s, Set<String> dic) {
        if (s == null) {
            return false;
        }
        String foundItem = "";

        for (int i = 0; s.length() > 0 && i < s.length(); i++) {
            foundItem += (s.charAt(i));
            if (dic.contains(foundItem)) {
                s = s.substring(i + 1);
                i = 0;
                foundItem = "";
            }
        }
        return dic.contains(s);
    }
}
