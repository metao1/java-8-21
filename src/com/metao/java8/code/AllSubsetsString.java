package com.metao.java8.code;

import java.util.LinkedList;
import java.util.List;

public class AllSubsetsString {

    public static void main(String[] args) {
        String st = "abc";
        List<String> result = new LinkedList<>();
        getAllSubsetsStr(st, result);
        System.out.println(result);
    }

    private static void getAllSubsetsStr(String st, List<String> result) {
        for (int i = 0; i < st.length(); i++) {
            for (int j = 0; j < st.length(); j++) {
                if (i <= j) {
                    String s = st.substring(i, j + 1);
                    result.add(s);
                }
            }
        }
    }
}
