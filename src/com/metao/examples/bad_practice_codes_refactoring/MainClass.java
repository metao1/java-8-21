package com.metao.examples.bad_practice_codes_refactoring;

public class MainClass {

    public static void main(String[] args) throws NoSuchFieldException {
        var imp = new ImplementedClass1();
        var imp2 = new ImplementedClass2();
        var state = new EventState();
        imp.process(state);
        imp2.process(state);
        System.out.println(getType(imp.type()).getSimpleName());
        System.out.println(getType(imp2.type()).getSimpleName());
    }

    static Class<?> getType(String eventType) throws NoSuchFieldException {
        return switch (eventType) {
            case "EVENT_1" -> ImplementedClass1.class;
            case "EVENT_2" ->  ImplementedClass2.class;
            default -> throw new NoSuchFieldException();
        };
    }
}
