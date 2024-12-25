package com.metao.examples.functionalcoursebuilder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


class Smoothie {
    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        String s = ingredients("Classic,mango,-applejuice,-avocado,-lime");
        System.out.println(s);
    }

    public static String ingredients(String order) {
        initSmoothies();
        return parseOrder(order);
    }

    static String parseOrder(String order) throws IllegalArgumentException {
        if(order == null || order.length() == 0) {
            throw new IllegalArgumentException("order can't be null or empty");
        }
        String[] items = order.split(",");
        if(items.length == 0)  {
            throw new IllegalArgumentException("order format is incorrect");
        }
        String smoothieName = items[0];
        if(smoothieName == null || smoothieName.length() == 0) {
            throw new IllegalArgumentException("smoothieName format is incorrect");
        }
        List<String> filteredItems = new LinkedList<>();
        var ingredientsOrder = Arrays.copyOfRange(items, 1, items.length);
        if(items.length > 1) {
            parseAdditional(ingredientsOrder ,filteredItems);
        }

        String result =  map.computeIfPresent(smoothieName, (k,v)-> {
            return Arrays.stream(parseIngredients(v))
                    .map(str-> str.replaceAll("\\s+", ""))
                    .filter(ing-> !filteredItems.contains(ing))
                    .peek(t-> checkAdditional(ingredientsOrder, t))
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(","));
        });
        if(result==null) {// smoothie didn't found
            throw new IllegalArgumentException("smoothie not found");
        }
        return result;
    }

    private static void checkAdditional(String[] ingredients, String item) {
        for(String ingredient: ingredients) {
            if(ingredient.equals(item))
                throw new IllegalArgumentException("additional ingredient is not allowed");
        }
    }

    private static String[] parseIngredients(String items) {
        return items.split("\\s*,");
    }

    private static void parseAdditional(String[] additional, List<String> filteredItems) {
        Arrays.stream(additional)
                .filter(Objects::nonNull)
                .filter(item-> item.startsWith("-"))
                .map(item-> item.replaceAll("-", ""))
                .forEach(filteredItems::add);
    }

    private static void initSmoothies() {
        map.put("Classic", "strawberry, banana, pineapple, mango, peach, honey");
        map.put("Freezie", "blackberry, blueberry, black currant, grape juice, frozen yogurt");
        map.put("Greenie", "green apple, lime, avocado, spinach, ice, apple juice");
        map.put("Just Desserts", "banana, ice cream, chocolate, peanut, cherry");
        map.put("Spinache", "ice, spinache, applejuice, avocado, lime");
    }
}