package com.metao.java8.challenges;

import java.util.LinkedList;
import java.util.List;

public class ShoppingOptions {

    public static void main(String[] args) {
        int k = 5;
        int[] possibilities = new int[]{1, 2, 3, 4};
        List<Integer> list = shoppingOptions(possibilities, k);
    }

    private static List<Integer> shoppingOptions(int[] possibilities, int k) {
        List<Integer> list = new LinkedList<>();
        greedyPossibility(possibilities, possibilities[0], k, list);
        System.out.println(list);
        list.clear();
        return null;
    }

    private static void greedyPossibility(int[] possibilities, int possibility, int amount, List<Integer> result) {
        if (amount <= 0) {
            return;
        }
        for (int poss : possibilities) {
            greedyPossibility(possibilities, poss, amount - poss, result);
            System.out.println(amount);
        }
    }
}
