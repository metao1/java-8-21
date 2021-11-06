package com.metao.java8.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleBraces {

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> list = printAllBraces(3);
        System.out.println(list);
    }

    static ArrayList<ArrayList<Character>> printAllBraces(int n) {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        printAllBracesRecursive(n, 0, 0, output, result);
        return result;
    }

    private static void printAllBracesRecursive(int n, int left, int right, ArrayList<Character> output, ArrayList<ArrayList<Character>> result) {
        if (left >= n && right >= n) {
            result.add(new ArrayList<>(output));
        }
        if (left < n) {
            output.add('{');
            printAllBracesRecursive(n, left + 1, right, output, result);
            output.remove(output.size() - 1);
        }
        if (left > right) {
            output.add('}');
            printAllBracesRecursive(n, left, right + 1, output, result);
            output.remove(output.size() - 1);
        }
    }
}
