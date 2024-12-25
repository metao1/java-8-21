package com.metao.examples.challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AllSubsets {

    public static void main(String[] args) {
        String st = "123";
        List<String> result = new LinkedList<>();
        getAllSubsetsStr(st, result);
        System.out.println(result);
    }

    private static void getAllSubsetsStr(String st, List<String> result) {
        for (int i = 0; i < st.length(); i++) {
            for (int j = 0; j < st.length(); j++) {
                if (i <= j) {
                    char[] chars = Arrays.copyOfRange(st.toCharArray(), i, j + 1);
                    result.add(String.valueOf(chars));
                }
            }
        }
    }
}
