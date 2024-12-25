package com.metao.examples.hackerrank.business;// <-- EXPAND to see the data classes

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Business {
    Integer id;
    Float rating;
    boolean veganFriendly;
    Integer price;
    Float distance;

    public Business(
            Integer id,
            Float rating,
            Boolean veganFriendly,
            Integer price,
            Float distance
    ) {
        this.id = id;
        this.rating = rating;
        this.veganFriendly = veganFriendly;
        this.price = price;
        this.distance = distance;
    }

    public Integer getId() {
        return this.id;
    }

    public Float getRating() {
        return this.rating;
    }

    public Boolean getVeganFriendly() {
        return this.veganFriendly;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Float getDistance() {
        return this.distance;
    }
}

class Solution {
    /*
     * Example:
     *
     * Input:
     *     businesses: [
     *         Business(id: 1, rating: 4.0, veganFriendly: true, price: 4, distance: 10.0),
     *         Business(id: 2, rating: 2.5, veganFriendly: false, price: 2, distance: 5.0),
     *         Business(id: 3, rating: 4.5, veganFriendly: false, price: 1, distance: 1.0),
     *         Business(id: 4, rating: 3.0, veganFriendly: true, price: 2, distance: 3.4),
     *         Business(id: 5, rating: 4.5, veganFriendly: true, price: 1, distance: 6.3),
     *         Business(id: 6, rating: 3.5, veganFriendly: true, price: 2, distance: 1.2),
     *     ]
     *     onlyVeganFriendly: false
     *     maxPrice: null
     *     maxDistance: 6.0
     *
     * Output:
     *     [3, 6, 4, 2]
     */
    public static List<Integer> filterAndSortBusinesses(
            List<Business> businesses,
            boolean onlyVeganFriendly,
            Integer maxPrice,
            Float maxDistance
    ) {
        // Todo: Complete Me
        long curr = System.currentTimeMillis();
        List<Integer> ids = businesses.stream()
                .parallel()
                .sorted(Comparator.comparing(Business::getRating, Comparator.reverseOrder()))
                .filter(b -> {
                    if (maxPrice != null) {
                        return b.price <= maxPrice;
                    }
                    return true;
                })
                .filter(b -> {
                    if (maxDistance != null) {
                        return b.distance <= maxDistance;
                    }
                    return true;
                })
                .filter(b -> {
                    if (onlyVeganFriendly) {
                        return b.veganFriendly;
                    }
                    return true;
                })
                .map(Business::getId)
                .collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - curr);
        return ids;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String jsonString = """
                    {
                        "businesses": [
                            {"id": 1, "rating": 4.0, "vegan_friendly": true, "price": 4, "distance": 10.0},
                            {"id": 2, "rating": 3.5, "vegan_friendly": false, "price": 2, "distance": 5.0},
                            {"id": 3, "rating": 4.5, "vegan_friendly": false, "price": 1, "distance": 1.0},
                            {"id": 4, "rating": 3.0, "vegan_friendly": true, "price": 2, "distance": 3.4},
                            {"id": 5, "rating": 4.5, "vegan_friendly": true, "price": 1, "distance": 6.3},
                            {"id": 6, "rating": 3.5, "vegan_friendly": true, "price": 2, "distance": 1.2}
                        ],
                        "filters": {
                            "only_vegan_friendly": true,
                            "max_price": 2,
                            "max_distance": 7.0
                        }
                    }
                    """;
//            String line;
//            while ((line = br.readLine()) != null) {
//                jsonString.append(line);
//            }

            JSONObject json = (JSONObject) new JSONParser().parse(jsonString);

            JSONArray jsonBusinesses = (JSONArray) json.get("businesses");

            Iterator<?> businessesIterator = jsonBusinesses.iterator();

            List<Business> businesses = new ArrayList<>();
            while (businessesIterator.hasNext()) {
                JSONObject business = (JSONObject) businessesIterator.next();
                businesses.add(new Business(
                        ((Long) business.get("id")).intValue(),
                        ((Double) business.get("rating")).floatValue(),
                        ((Boolean) business.get("vegan_friendly")),
                        ((Long) business.get("price")).intValue(),
                        ((Double) business.get("distance")).floatValue()
                ));
            }

            JSONObject filters = (JSONObject) json.get("filters");

            List<Integer> filterAndSortedBusinessIds = filterAndSortBusinesses(
                    businesses,
                    ((Boolean) filters.get("only_vegan_friendly")),
                    (filters.get("max_price") != null) ? ((Long) filters.get("max_price")).intValue() : null,
                    (filters.get("max_distance") != null) ? ((Double) filters.get("max_distance")).floatValue() : null
            );

            for (Integer businessId : filterAndSortedBusinessIds) {
                System.out.println(businessId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}