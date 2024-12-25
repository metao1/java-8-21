package com.metao.java8.functionalcoursebuilder;

import java.math.BigDecimal;

public class CourseBuilder {

    private BigDecimal id;
    private String name;

    private CourseBuilder() {
    }

    public CourseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder id(BigDecimal id) {
        this.id = id;
        return this;
    }

    public Course build() {
        return new Course(this.id, this.name);
    }

    public static CourseBuilder builder() {
        return new CourseBuilder();
    }

}