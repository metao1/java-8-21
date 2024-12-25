package com.metao.examples.hackerrank;

public class Percentage {

    public static void main(String[] args) {

    }

    static float mapBetween(float currentNum, float minAllowed, float maxAllowed, float min, float max) {
        return (maxAllowed - minAllowed) * (currentNum - min) / (max - min) + minAllowed;
    }
}
