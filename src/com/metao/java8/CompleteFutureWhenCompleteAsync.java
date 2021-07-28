package com.metao.java8;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CompleteFutureWhenCompleteAsync<T> {

    private int sum;

    public static void main(String[] args) throws InterruptedException {
        new CompleteFutureWhenCompleteAsync();
    }

    public CompleteFutureWhenCompleteAsync() {
        long start = System.nanoTime();
        Random random = new Random(100);

        List<Integer> expectedList = random.ints(10_000_000, 1, 5525)
                .boxed()
                .collect(Collectors.toList());
        Optional<Integer> reduce = expectedList.stream().reduce(Integer::max);
        System.out.println(reduce.orElse(0));
        System.out.println((System.nanoTime() - start) / 1000);
    }

    private static class FindMaxSpliterator implements Spliterator<Integer> {
        int start, end;
        int[] arr;

        public FindMaxSpliterator(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            if (start <= end) {
                action.accept(arr[start]);
                start++;
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            if (end - start < 1000) {
                return null;
            }

            int mid = (start + end) / 2;
            int oldstart = start;
            start = mid + 1;
            return new FindMaxSpliterator(arr, oldstart, mid);
        }

        @Override
        public long estimateSize() {
            return end - start;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
        }
    }
}

