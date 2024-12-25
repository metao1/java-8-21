package com.metao.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BitwiseOperations {
    public static void main(String[] args) {
        var var1 = 0xFFFFFFFFL;
        String var2 = String.format("%d.%d.%d.%d", var1 & 255, var1 >> 8 & 255, var1 >> 16 & 255, var1 >> 24 & 255);
        System.out.println(var2);
        Map<String, String> sd = new HashMap<>();
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        if (!Arrays.equals(charsS, charsT)) return false;
        return true;
    }
}