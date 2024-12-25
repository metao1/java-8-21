package com.metao.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsyncOperator {

    public AsyncOperator() {

        Supplier<String> stringCallable = () -> "hello";

        Comparator<Integer> comparator = (a, b) -> (a * b);
        Function<Object, Object> identity = Function.identity();

        CustomInterface<Integer, Integer> customInterface = HashMap::new;
        Map<Integer, Integer> revert = customInterface.revert(10, 100);

        revert.put(1, 20);
        revert.put(2, 15);
        revert.put(3, 10);
        revert.put(4, 200);
        revert.put(6, 20);
        revert.put(10, 20);
        revert.put(5, 20);
        System.out.println(revert);
        Map<Integer, List<Integer>> collect = revert.entrySet().stream()
                .sorted((o1, o2) -> Math.max(o1.getValue(), o2.getValue()))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        System.out.println(collect);
        Comparator<String> tComparator = this::compare;

        Integer[] a = new Integer[]{10, 1, 209, 12, 665};
        String[] test = new String[]{"a", "c", "d", "b"};
        Object[] mini = tComparator.sortedObject(test);
        for (Object ignored : mini) {
            System.out.print(((String) ignored).concat("\t"));
        }
    }

    interface CustomInterface<K, V> {
        Map<K, V> revert(K a, V b);
    }

    public static void main(String[] args) throws Exception {
//        AsyncExecutor<String> ae1 = new ThreadAsyncExecutor();
//        AsyncResult<String> runner1 = runner(ae1);
//        String s1 = ae1.endProcess(runner1);
//
//        AsyncExecutor<String> ae2 = new ThreadAsyncExecutor();
//        AsyncResult<String> runner2 = runner(ae2);
//        String s2 = ae1.endProcess(runner2);

        Map<String, String> collect = List.of("Reza", "ali", "1").stream()
                .collect(Collectors.toMap(String::toUpperCase, Function.identity()));

        System.out.println(collect);
        AsyncOperator asyncOperator = new AsyncOperator();
//        System.out.println(s1);
//        System.out.println(s2);
//        runner1.await();
//        runner2.await();
    }

    @FunctionalInterface
    interface Comparator<T> {
        T compare(T a, T b);

        boolean equals(Object a);

        default void sort(T[] a) {
            Arrays.sort(a);
        }

        default Object[] array(T[] a) {
            return Arrays.stream(a).toArray(Object[]::new);
        }

        default Object[] sortedObject(T[] a) {
            return Arrays.stream(a).sorted().toArray();
        }
    }

    public String compare(String a, String b) {
        return a + b;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    private static AsyncResult<String> runner(AsyncExecutor<String> ae) throws Exception {
        return ae.startProcess(() -> {
            System.out.println("Starting the process");
            Thread.sleep(1000);
            System.out.println("Star");
            return "ok";
        }, (value, ex) -> {
            if (ex != null) {
                System.out.println(ex.getMessage());
            } else {
                System.out.println(value);
            }
        });
    }

    interface AsyncResult<T> {
        boolean isCompleted();

        T getValue() throws ExecutionException;

        void await() throws InterruptedException;
    }

    interface AsyncCallback<T> {
        void onCompleted(T value, Exception ex);
    }

    private interface AsyncExecutor<T> {
        AsyncResult<T> startProcess(Callable<T> callable) throws InterruptedException;

        AsyncResult<T> startProcess(Callable<T> callable, AsyncCallback<T> cb) throws Exception;

        T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;

    }

    private static final class CompletableResult<T> implements AsyncResult<T> {

        private final AsyncCallback<T> callback;
        private T value;
        private final static Object lock = new Object();
        private final static int RUNNING = 0;
        private final static int AWAITING = 1;
        private final static int FAILED = 2;
        private final static int COMPLETED = 3;
        private volatile int state = RUNNING;
        private Exception exception;

        public CompletableResult(AsyncCallback<T> cb) {
            this.callback = cb;
        }

        @Override
        public boolean isCompleted() {
            return state == COMPLETED;
        }

        @Override
        public T getValue() throws ExecutionException {
            switch (state) {
                case COMPLETED:
                    return value;
                case FAILED:
                    throw new ExecutionException(getException());
                default:
                    throw new IllegalStateException("Execution is not completed yet!");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                while (!isCompleted()) {
                    this.state = AWAITING;
                    lock.wait();
                }
            }
        }

        public void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            if (this.callback != null) {
                this.callback.onCompleted(value, getException());
            }
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        public void setException(Exception e) {
            this.exception = e;
        }

        public Exception getException() {
            this.state = FAILED;
            return exception;
        }
    }

    static class ThreadAsyncExecutor implements AsyncExecutor<String> {

        private final AtomicInteger threadCounter = new AtomicInteger();

        @Override
        public AsyncResult<String> startProcess(Callable<String> callable) throws InterruptedException {
            return startProcess(callable, null);
        }

        @Override
        public AsyncResult<String> startProcess(Callable<String> callable, AsyncCallback<String> cb) throws InterruptedException {
            var result = new CompletableResult<>(cb);
            new Thread(() -> {
                try {
                    result.setValue(callable.call());
                } catch (Exception e) {
                    result.setException(e);
                }
            }, "Executor-" + threadCounter.incrementAndGet()).start();
            return result;
        }

        @Override
        public String endProcess(AsyncResult<String> asyncResult) throws ExecutionException, InterruptedException {
            if (!asyncResult.isCompleted()) {
                asyncResult.await();
            }
            return asyncResult.getValue();
        }

    }

}
