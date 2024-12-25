package com.metao.java8.functionalcoursebuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public class TaxMap {

    private final Map<TaxClass, TaxCalculator> map = new LinkedHashMap<>();

    void addTaxCalculator(TaxClass taxClass, TaxCalculator taxCalculator) {
        map.putIfAbsent(taxClass, taxCalculator);
    }

    TaxCalculator getTaxCalculator(TaxClass taxClass) {
        return map.get(taxClass);
    }

}
