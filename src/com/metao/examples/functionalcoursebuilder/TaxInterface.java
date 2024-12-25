package com.metao.examples.functionalcoursebuilder;

import java.math.BigDecimal;

public interface TaxInterface {
    BigDecimal apply(Tax tax, TaxClass taxClass);
}
