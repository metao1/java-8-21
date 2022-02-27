package com.metao.java8;

import java.util.function.BiConsumer;

public class BinaryOperation {

    //BiConsumer<Test,String> -> BiConsumer<T,U>
    BiConsumer<Test, String> add = Test::add;
    BiConsumer<Test, String> bc = (r, t) -> r.add(t);

    MyConsumer<String, Integer> mc1 = (t, u) -> changer(t, u);
    MyConsumer<TestClass, Integer> mc2 = (t, u) -> t.add(u);
    MyConsumer<TestClass, Integer> mc4 = TestClass::add;

    MyConsumer3<TestClass, Integer, Boolean> mc5 = TestClass::add;

    MyConsumer3<TestClass, Integer, Boolean> mc6 = (t, u) -> t.add(u);

    MyConsumer4<TestClass, Integer, TestClass, Boolean> mc7 = TestClass::addMore;
    
    class TestClass {
        boolean add(Integer s) {
            return true;
        }

        boolean addMore(Integer s, TestClass c) {
            return true;
        }
    }

    interface MyConsumer4<T, U, R, S> {
        S accept(T t, U u, R r);
    }

    interface MyConsumer<T, U> {
        void accept(T t, U u);
    }

    interface MyConsumer3<T, U, R> {
        R accept(T t, U u);
    }


    interface MyConsumer2<T, U> {
        U accept(T t);
    }

    static Integer changer2(String item1) {
        return Integer.parseInt(item1);
    }

    static Integer changer(String item1, Integer item2) {
        return Integer.parseInt(item1);
    }

    class Test {

        void add(String r) {

        }

        boolean addAll(Test s, Test t) {
            return false;
        }
    }
}
