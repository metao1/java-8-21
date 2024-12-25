package com.metao.examples.functionalcoursebuilder;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public class Student {
    private final Set<Course> courses = new LinkedHashSet<>();
    private final BigDecimal number;
    private String name;

    public Student(BigDecimal number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}