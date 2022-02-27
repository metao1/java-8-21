package com.metao.java8.hackerrank;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMissingPositiveNumberInArray {

    public static void main(String[] args) {
        var a = new int[]{0, 1};
        int solution = solution(a);
        int solutionFaster = solutionFaster(a);
        System.out.println(solution);
        System.out.println("solutionFaster = " + solutionFaster);
    }

    private static int solutionFaster(int[] nums) {
        int n = nums.length;

        boolean one = false;
        for (int num : nums) {
            if (num == 1) {
                one = true;
                break;
            }
        }

        if (!one) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]) - 1;
            nums[a] = -Math.abs(nums[a]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    //Find the smallest positive integer that does not occur in a given array
    private static int solution(int[] array) {
        Set<Integer> set = Stream.of(array)
                .flatMapToInt(Arrays::stream)
                .filter(i -> i >= 0)
                .boxed()
                .collect(Collectors.toSet());
        int max = 1;
        for (int i = 1; i <= array.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
            max = Math.max(max, i);
        }
        return max + 1;
    }
}
