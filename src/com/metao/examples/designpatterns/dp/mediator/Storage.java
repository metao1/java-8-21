package com.metao.examples.designpatterns.dp.mediator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class Storage<T> {
    T value;

    public T getValue() {
        return value;
    }

    void setValue(Mediator<T> mediator, String storageName, T value) {
        this.value = value;
        mediator.notifyChanges(storageName);
    }

    private static class Mediator<T> {
        private final Map<String, Storage<T>> storageMap = new LinkedHashMap<>();
        private final List<Consumer<String>> observers = new CopyOnWriteArrayList<>();

        public void setValue(String storageName, T value) {
            var storage = storageMap.computeIfAbsent(storageName, name -> new Storage<>());
            storage.setValue(this, storageName, value);
        }

        public Optional<T> getValue(String storageName) {
            return Optional.ofNullable(storageMap.get(storageName)).map(Storage::getValue);
        }

        public void addObserver(String storageName, Runnable observer) {
            observers.add(eventName -> {
                if (eventName.equals(storageName)) {
                    observer.run();
                }
            });
        }

        public void notifyChanges(String storageName) {
            observers.forEach(observer -> observer.accept(storageName));
        }
    }

    public static void main(String[] args) {
        var mediator = new Mediator<>();
        mediator.setValue("bob", 20);
        mediator.setValue("alice", 24);
        mediator.getValue("alice").ifPresent(age -> System.out.println("age for alice: " + age));
        mediator.addObserver("bob", () -> System.out.println("new age for bob is:" + mediator.getValue("bob").orElseThrow()));
        mediator.setValue("bob", 12);
    }
}
