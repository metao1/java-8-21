package com.metao.examples;

public class PermutationString {

    public static void main(String[] args) {
        String s = customSortString("kqep", "pekeq");
        System.out.println(s);
    }

    private static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder newWord = new StringBuilder();
        for(char ch: order.toCharArray()) {
            while(s.indexOf(ch) != -1 && sb.length() > 0) {
                newWord.append(ch);
                s = sb.deleteCharAt(s.indexOf(ch)).toString();
            }
        }
        System.out.println(sb);
        return newWord.append(sb).toString();
    }
}
