package com.metao.java8.challenges;

import java.util.LinkedList;
import java.util.List;

public class FindKthPermutation {

    public static void main(String[] args) {
        Character[] chars = new Character[]{'1', '2', '3', '4'};
        List<String> result = permute(chars);
        System.out.println(result);
    }

    static List<String> permute(Character[] chars) {
        List<String> result = new LinkedList<>();
        boolean[] freq = new boolean[chars.length];
        findKthPermutation(chars, "", result, freq);
        return result;
    }

    private static void findKthPermutation(Character[] chars, String sb, List<String> result, boolean[] freq) {
        if (sb.length() == chars.length) {
            result.add(sb);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                sb += chars[i];
                findKthPermutation(chars, sb, result, freq);
                sb = sb.substring(0, sb.length() - 1);
                freq[i] = false;
            }
        }
    }
}
