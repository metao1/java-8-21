package com.metao.java8.functionalcoursebuilder;

import java.math.BigDecimal;

public interface TaxInterface {
    BigDecimal apply(Tax tax, TaxClass taxClass);
}
