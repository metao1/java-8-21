package com.metao.java8.challenges;

import java.util.Arrays;

public class CoinChainOptimal {
    public static void main(String[] args) {
        int coinChange = solveCoinChange(new int[]{1, 2, 5}, 7);
        System.out.println(coinChange);
    }

    static int solveCoinChange(int[] denominations, int amount) {
        int[] T = new int[amount + 1];
        Arrays.fill(T, amount);
        T[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int denomination : denominations) {
                if (a - denomination >= 0) {
                    T[a] = Math.min(T[a], 1 + T[a - denomination]);
                }
            }
        }
        if (T[amount] != amount + 1) {// if it is not the default value
            return T[amount];
        }else {
            return -1;
        }
    }
}
