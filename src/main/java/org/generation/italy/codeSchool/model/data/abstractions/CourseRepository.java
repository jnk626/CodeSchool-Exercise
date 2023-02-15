package org.generation.italy.codeSchool.model.data.abstractions;

import org.generation.italy.codeSchool.model.Course;

import java.util.List;

public interface CourseRepository {
    Course findById(long id);
    List<Course> findByTitleContains(String part);
    Course create(Course course);
    void update(Course course);
    void deleteById(long id);
}
