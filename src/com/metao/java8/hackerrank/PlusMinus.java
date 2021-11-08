package com.metao.java8.hackerrank;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlusMinus {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.000000");
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        List<Integer> arr = List.of(-1, -4, 1, 1, 2);
        for (Integer item : arr) {
            if (item > 0) {
                int preValue = map.get(1) + 1;
                map.put(1, preValue);
            } else if (item == 0) {
                int preValue = map.get(3) + 1;
                map.put(3, preValue);
            } else {
                int preValue = map.get(2) + 1;
                map.put(2, preValue);
            }
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            double fraction = Double.parseDouble(decimalFormat.format(((double) en.getValue() / arr.size())));
            System.out.println(decimalFormat.format(fraction));
        }
    }

}
