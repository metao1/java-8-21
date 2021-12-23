package com.metao.java8.leetcode;

public class ReplaceAllQuestionMarks {

    public static void main(String[] args) {
        String s = "aa?bb?";
        String replacedString = replaceAllQuestionMarks(s);
        System.out.println(replacedString);
    }

    private static String replaceAllQuestionMarks(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        return new String(applyFilter(0, s.toCharArray()));
    }

    private static char[] applyFilter(int start, char[] st) {
        if (start == st.length || st.length <= 2)
            return st;
        if (st[start] == '?') {
            start++;
            if(shouldChange(start, st)){

            }
        }
        return st;
    }

    private static boolean shouldChange(int start, char[] st) {
        return false;
    }
}
