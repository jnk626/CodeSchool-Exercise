package org.generation.italy;

import org.generation.italy.codeSchool.model.Course;
import org.generation.italy.codeSchool.model.data.abstractions.CourseRepository;
import org.generation.italy.codeSchool.model.data.implementations.InMemoryCourseRepository;

public class Main {
    public static void main(String[] args) {
        CourseRepository c = new InMemoryCourseRepository();
        Course x = c.findById(22);

        System.out.println(x.getTitle());
    }
}