package com.metao.examples.challenges;

class CoinChanging {
    public static void main(String[] args) {
        int coinChange = solveCoinChange(new int[]{1, 2, 5}, 7);
        System.out.println(coinChange);
    }

    static int solveCoinChange(int[] denominations, int amount) {
        int[] T = new int[amount + 1];
        T[0] = 1;

        for (int denomination : denominations) {
            for (int j = denomination; j <= amount; j++) {
                T[j] += T[j - denomination];
            }
        }

        return T[amount];
    }
}  