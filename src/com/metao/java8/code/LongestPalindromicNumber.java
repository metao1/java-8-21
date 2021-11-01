package com.metao.java8.code;

public class LongestPalindromicNumber {

    public LongestPalindromicNumber() {
    }

    public static void main(String[] args) throws InterruptedException {
        int digit1 = 99, digit2 = 99;
        String multiplyResult = null;
        for (int n = digit1; n > 0; n--) {
            for (int m = digit2; m > 0; m--) {
                String val = String.valueOf(n * m);
                if (val.length() % 2 == 0) {
                    String part1 = val.substring(0, val.length() / 2);
                    String part2 = new StringBuilder(val.substring(val.length() / 2)).reverse().toString();
                    if (part1.equalsIgnoreCase(part2)) {
                        multiplyResult = String.valueOf(n).concat("*").concat(String.valueOf(m));
                        break;
                    }
                }
            }
            if (multiplyResult != null) {
                break;
            }
        }
        System.out.println(multiplyResult);
    }
}
