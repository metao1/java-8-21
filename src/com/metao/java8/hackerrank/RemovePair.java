package com.metao.java8.hackerrank;

public class RemovePair {

    public static void main(String[] args) {
        String solution = solution("ABCDE");
        System.out.println("solution = " + solution);
    }

    //Remove all occurrences of `AB` or 'BA' and `CD` or 'DC' from a string
    public static String solution(String str) {
        // base case
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        // `i` maintains the position of the current char in the input string.
        // `k` maintains the next free position in the output string.
        int i = 0, k = 0;

        // do till the end of the string is reached
        while (i < str.length()) {
            System.out.println("k = " + k + ", i = " + i + ", SEQ=" + new String(chars));
            if (sequenceExist(chars, i, k)) {
                --k;
                ++i;
            } else {
                // for any other character, increment both `i` and `k`
                chars[k++] = chars[i++];
            }
            System.out.println("k = " + k + ", i = " + i + ", SEQ=" + new String(chars));
        }

        return new String(chars).substring(0, k);
    }

    private static boolean sequenceExist(char[] chars, int i, int k) {
        // if the current character is 'B' and previous (need not be adjacent)
        // was 'A', also for C,D increment `i` and decrement `k`
        return chars[i] == 'C' && (k > 0 && chars[k - 1] == 'D') ||
                chars[i] == 'D' && (k > 0 && chars[k - 1] == 'C') ||
                chars[i] == 'A' && (k > 0 && chars[k - 1] == 'B') ||
                chars[i] == 'B' && (k > 0 && chars[k - 1] == 'A');
    }
}
