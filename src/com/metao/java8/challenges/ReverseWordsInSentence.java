package com.metao.java8.challenges;

import java.util.Arrays;

public class ReverseWordsInSentence {

    public static void main(String[] args) {
        String sentence = "We love Java";
        char[] chars = sentence.toCharArray();
        reverseWordsInSentenceMethod1(chars);
        System.out.println(chars);
    }

    private static void reverseWordsInSentenceMethod1(char[] sentence) {
        String s = new String(sentence);
        String[] strings = s.split("\\s");
        String[] newStr = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            newStr[i] = strings[strings.length - i - 1];
        }
        String s1 = Arrays.toString(newStr);
        s1 = s1.replaceAll("\\[|\\]|,", "");
        for (int i = 0; i < s1.length(); i++) {
           sentence[i]= s1.charAt(i);
        }
    }
}
