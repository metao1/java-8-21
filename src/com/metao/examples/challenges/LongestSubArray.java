package com.metao.examples.challenges;

import java.util.TreeMap;

public class LongestSubArray {

    public static void main(String[] args) {

        int longestSubarray = longestSubarray(new int[]{0, 1, 2, 1, 2, 3}, 1);
        System.out.println(longestSubarray);
    }

    public static int longestSubarray(int[] nums, int limit) {
        if (nums.length == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int maxSize = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.isEmpty()) map.put(nums[j], j);
            else {
                int min = map.firstKey();

                while (!map.isEmpty() && Math.abs(nums[i] - min) > limit) {
                    int index = map.get(min);
                    while (j <= index) map.remove(nums[j++]);
                    if (!map.isEmpty()) min = map.firstKey();
                }

                int max = -1;
                if (!map.isEmpty()) max = map.lastKey();

                while (!map.isEmpty() && Math.abs(max - nums[i]) > limit) {
                    int index = map.get(max);
                    while (j <= index) map.remove(nums[j++]);
                    if (!map.isEmpty()) max = map.lastKey();
                }

                map.put(nums[i], i);
                maxSize = Math.max(maxSize, i - j + 1);
            }
        }
        return maxSize;
    }
}
