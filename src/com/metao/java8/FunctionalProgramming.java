package com.metao.java8;

import com.metao.java8.functionalcoursebuilder.StudentBuilder;

import java.math.BigDecimal;

import static com.metao.java8.functionalcoursebuilder.StudentBuilder.course;

public class FunctionalProgramming {

    public static void main(String[] args) {
        var student = StudentBuilder.of(
                BigDecimal.ONE, "Mehrdad",
                course(course -> course.name("Math1").id(BigDecimal.valueOf(1))),
                course(course -> course.name("Math2").id(BigDecimal.valueOf(2)))
        );
        student.getCourses().forEach(System.out::println);
    }

}
