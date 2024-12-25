package com.metao.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaExpression {

    static Function<String, String> getMyCar() {
        return (arg) -> arg != null ? arg : "no car yet!";
    }

    static Function<String, Integer> countLength() {
        return (arg) -> arg != null ? arg.length() : 0;
    }

    static Function<String, String> capitalize() {
        return (txt) -> txt != null ? txt.toUpperCase() : null;
    }

    static String filterWish(String text, Function<String, String> textFunction) {
        return text == null ? null : textFunction.apply(text);
    }

    static String compareAndReturnLongest(String text1, String text2) {
        return (text1 == null || text2 == null) ? null : text1.compareTo(text2) > 0 ? text1 : text2;
    }

    @FunctionalInterface
    interface IsPrime {
        boolean isCoefficient(int num1, int num2);
    }

    @FunctionalInterface
    interface FindGuilty {
        boolean judge(String person);
    }

    static class Placement {
        String template;
        String replacement;

        public Placement(String template, String replacement) {
            this.template = template;
            this.replacement = replacement;
        }
    }

    static Function<Placement, Consumer<String>> fancySubstitute = (Placement placement) ->
            (finding) -> System.out.print(placement.template.replace(finding, placement.replacement));

    static Consumer<String> substituteAndPrint(Placement placement) {
        return (finding) -> {
            System.out.print(placement.template.replace(finding, placement.replacement));
        };
    }

    static Consumer<String> justSubstitute(Placement placement) {
        return (finding) -> {
            placement.template = placement.template.replace(finding, placement.replacement);
        };
    }

    @FunctionalInterface
    interface MathClass<T> {
        T filter();
    }

    LambdaExpression() {
        List<CompletableFuture<Runnable>> thread = new Vector<>();
        Supplier<Runnable> supplier = () -> (Runnable) () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hello");
            }
        };
//
//        Consumer<Runnable> s = s1 -> {
//            thread.add(CompletableFuture.supplyAsync(s1));
//        };
//
//        s.config(supplier);
        thread.forEach(CompletableFuture::join);

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream()
                        .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println(result);
    }

    public static void main(String[] args) {
        new LambdaExpression();
        System.out.println(getMyCar().apply("Ferrari"));// Should print "Ferrari"
        System.out.println(getMyCar().apply(null));// Should print "no car yet!"
        System.out.println(countLength().apply("count should print the length of this text"));
        String text = "count should print the length of this text";
        assert countLength().apply(text) == text.length();
        String text1 = "long text";
        String text2 = "longer text";
        System.out.println(compareAndReturnLongest(text1, text2));
        System.out.println(filterWish(text1, (txt) -> txt.length() > text2.length() ? txt : text2));
        System.out.println(filterWish(text1, (txt) -> txt + "," + txt));
        Function<String, String> functionReference = (txt) -> txt.length() > 0 ? "" : null;
        filterWish(text, functionReference);
        System.out.println(filterWish(text, capitalize()));
        BiFunction<String, String, String> compareAndReturnLongest = LambdaExpression::compareAndReturnLongest;
        BiFunction<String, String, String> longerText = (txt1, txt2) -> (txt1 == null || txt2 == null) ? null : txt1.length() > txt2.length() ? txt1 : txt2;

        BiFunction<Integer, Integer, Boolean> isPrimeBiFunction = (Integer num1, Integer num2) -> num1 % num2 == 0;

        IsPrime isPrime = (int num1, int num2) -> num1 % num2 == 0;

        isPrime.isCoefficient(2, 2);
        isPrime.isCoefficient(2, 3);

        FindGuilty findGuilty = (String person) -> person.contains("is guilty");

        System.out.println(findGuilty.judge("person is guilty"));

        System.out.println(findGuilty.judge("person is not guilty"));

        Optional<String> someOptionInCar = Optional.of("automatic windows");

        String carOption = someOptionInCar.get();
        System.out.println(carOption);

        System.out.println(someOptionInCar.isPresent());
        String template = " my car {{text}} found by Police";
        String anotherTemplate = " searched in {{text}} city";
        Function<Placement, Consumer<String>> substitute = LambdaExpression::substituteAndPrint;
        substitute
                .apply(new Placement(anotherTemplate, "California"))
                .andThen(substitute.apply(new Placement(template, "Ferrari")))
                .accept("{{text}}");
        System.out.println();
        fancySubstitute.apply(new Placement(template, "Ferrari"))
                .andThen(substitute.apply(new Placement(anotherTemplate, "California")))
                .accept("{{text}}");
        System.out.println();

        List<Placement> templateList = Arrays.asList(
                new Placement(template, "Ferrari"),
                new Placement(anotherTemplate, "California"),
                new Placement(".It was {{text}} who has stolen it later.", "not clear")
        );


        templateList.forEach(t -> justSubstitute(t).accept("{{text}}"));

        templateList.forEach(t -> System.out.print(t.template));
    }
}
