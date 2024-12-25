package com.metao.examples.functionalcoursebuilder;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Consumer;

public class StudentBuilder {

    public static Student of(BigDecimal id, String name, CourseBuilder... courses) {
        Student student = new Student(id);
        student.setName(name);
        Arrays.stream(courses).forEach(b -> student.addCourse(b.build()));
        return student;
    }

    public static CourseBuilder course(Consumer<CourseBuilder> builderConsumer) {
        var cb = CourseBuilder.builder();
        builderConsumer.accept(cb);
        return cb;
    }

}