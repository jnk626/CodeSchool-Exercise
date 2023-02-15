package org.generation.italy.codeSchool.model.data.abstractions;

import org.generation.italy.codeSchool.model.Course;
import org.generation.italy.codeSchool.model.data.exceptions.DataException;
import org.generation.italy.codeSchool.model.data.exceptions.EntityNotFoundException;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    Optional<Course> findById(long id) throws DataException;
    List<Course> findByTitleContains(String part) throws DataException;
    Course create(Course course) throws DataException;
    void update(Course course) throws EntityNotFoundException, DataException;
    void deleteById(long id) throws EntityNotFoundException, DataException;
}
