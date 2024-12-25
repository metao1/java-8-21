package com.metao.examples.hackerrank;

public class RecursiveDigitSum {

    public static void main(String[] args) {
        int result = superDigit(String.valueOf(121154), 10);
        assert result == 5;
    }

    public static int superDigit(String n, int k) {
        if(n.length() == 1) {
            return Integer.parseInt(n);
        }
        long sum = 0;
        for(char ch : n.toCharArray()){
            sum += Long.parseLong(String.valueOf(ch));
        }
        if(k>0){
            sum*=k;
        }
        return superDigit(String.valueOf(sum),0);
    }

}
