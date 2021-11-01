package com.metao.java8.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindAllSubsets {
    public static void main(String[] args) {
        List<Integer> v = new LinkedList<>() {{
            add(2);
            add(3);
            add(4);
        }};
        List<HashSet<Integer>> sets = new LinkedList<>();
        get_all_subsets(v, sets);
        System.out.println(sets);
    }

    static void get_all_subsets(List<Integer> v, List<HashSet<Integer>> sets) {
        HashSet<Integer> set = new HashSet<>();
        sets.add(new HashSet<>());
        get_all_subsets_memo(v, set, sets);
    }

    private static void get_all_subsets_memo
            (List<Integer> items, HashSet<Integer> set, List<HashSet<Integer>> sets) {
        if (set.size() > 0 && !sets.contains(set)) {
            sets.add(new HashSet<>(set));
        }
        for (Integer item : items) {
            if (!set.contains(item)) {
                set.add(item);
                get_all_subsets_memo(items, set, sets);
                set.remove(item);
            }
        }
    }
}
