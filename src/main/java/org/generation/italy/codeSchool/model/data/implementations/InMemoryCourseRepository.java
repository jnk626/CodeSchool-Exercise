package org.generation.italy.codeSchool.model.data.implementations;

import org.generation.italy.codeSchool.model.Course;
import org.generation.italy.codeSchool.model.data.abstractions.CourseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {
    private Map<Long, Course> dataSource = new HashMap<>();

    @Override
    public Course findById(long id) {
        return dataSource.get(id);
    }

    @Override
    public List<Course> findByTitleContains(String part) {
        return null;
    }

    @Override
    public Course create(Course course) {
        return null;
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void deleteById(long id) {

    }
}
