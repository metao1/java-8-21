package com.metao.java8;

import java.util.TreeSet;

public class TreeSetBestPractices {

    public static void main(String[] args) {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(1);
        tree.add(4);
        tree.add(5);
        System.out.println(tree.ceiling(2));
    }
}
