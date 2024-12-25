package com.metao.examples.functionalcoursebuilder;

import java.math.BigDecimal;

public class Tax {
    BigDecimal value;

    public Tax setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }
}
