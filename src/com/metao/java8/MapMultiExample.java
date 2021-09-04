package com.metao.java8;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMultiExample {

    public MapMultiExample() {
        class SumUpFruits {
            <T, R> void contactUser(Supplier<List<T>> supplier, BiConsumer<T, Consumer<R>> concatUserFunction, Consumer<R> accumulator) {
                for (T item : supplier.get()) {
                    concatUserFunction.accept(item, accumulator);
                }
            }

            static Stream<Object> sumUp(Supplier<List<String>> supplier) {
                List<String> list = supplier.get();
                return list.stream().mapMulti((integer, objectConsumer) -> {
                    for (int i = 0; i < integer.length(); i++) {
                        if (Character.isUpperCase(integer.charAt(i))) {
                            objectConsumer.accept(integer.charAt(i) + "-> capitalized");
                        } else {
                            objectConsumer.accept(integer.charAt(i) + "-> lowercase");
                        }
                    }
                });
            }
        }

        AtomicInteger sum = new AtomicInteger();
        SumUpFruits sumUpFruits = new SumUpFruits();
        sumUpFruits.contactUser(() -> List.of(1, 2, 4), (a, b) -> b.accept(a), i -> sum.set(sum.get() + (Integer) i));
        System.out.println(sum);
        Stream<Object> objectStream = SumUpFruits.sumUp(() -> List.of("Helicopter", "airplane", "ship"));
        System.out.println(objectStream.collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        MapMultiExample mapMultiExample = new MapMultiExample();

    }

}
