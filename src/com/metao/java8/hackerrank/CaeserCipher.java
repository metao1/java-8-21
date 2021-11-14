package com.metao.java8.hackerrank;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CaeserCipher {

    public static void main(String[] args) {
        String expectedOutput = caesarCipher("abcdefghijklmnopqrstuvwxyz", 3);
        System.out.println(expectedOutput);
        assert expectedOutput.equals("defghijklmnopqrstuvwxyzabc");
    }

    public static String caesarCipher(String s, int k) {
        List<Character> chList = new LinkedList<>();
        if (s.equals("\\s+")) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    ch += k;
                    while (ch > 122) {
                        ch = (char) (96 + ch % 122);
                    }
                } else if (Character.isUpperCase(ch)) {
                    ch += k;
                    while (ch > 90) {
                        ch = (char) (64 + ch % 90);
                    }
                }
            }
            chList.add(ch);
        }
        return chList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
