package com.metao.examples.functionalcoursebuilder;

import java.math.BigDecimal;

public class TaxCalculator {

    Tax tax;
    TaxClass taxClass;

    public TaxCalculator(Tax tax, TaxClass taxClass) {
        this.tax = tax;
        this.taxClass = taxClass;
    }

    public BigDecimal calculate(TaxInterface taxInterface) {
        return taxInterface.apply(tax, taxClass);
    }
}
