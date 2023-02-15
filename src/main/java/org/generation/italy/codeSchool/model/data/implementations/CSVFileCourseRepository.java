package org.generation.italy.codeSchool.model.data.implementations;

import org.generation.italy.codeSchool.model.Course;
import org.generation.italy.codeSchool.model.data.abstractions.CourseRepository;
import org.generation.italy.codeSchool.model.data.exceptions.DataException;
import org.generation.italy.codeSchool.model.data.exceptions.EntityNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class CSVFileCourseRepository implements CourseRepository {
    private String fileName;

    private static long nextId;

    public static final String DEFAULT_FILE_NAME = "Corsi.csv";

    public CSVFileCourseRepository(){
        this.fileName = DEFAULT_FILE_NAME;
    }

    public CSVFileCourseRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Optional<Course> findById(long id) throws DataException{
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String s : lines) {
                String[] trimmed = s.split(",");
                long courseId = Long.parseLong(trimmed[0]);
                if (courseId == id) {
                    Course found = new Course(courseId, trimmed[1], trimmed[2], trimmed[3],
                            Double.parseDouble(trimmed[4]));
                    Optional<Course> result = Optional.of(found);
                    return result;
                }
            }
            return Optional.empty();
        } catch (IOException e) {
            throw new DataException("Errore nella lettura del file", e);
        }

    }

    @Override
    public List<Course> findByTitleContains(String part) {
        return null;
    }

    @Override
    public Course create(Course course) throws DataException {
        try(FileOutputStream output = new FileOutputStream(fileName, true);
                PrintWriter pw = new PrintWriter(output)) {
            course.setId(++nextId);
            String csvLine = courseToCSV(course);
            pw.println(csvLine);
            return course;
        } catch(IOException e){
            throw new DataException("Errore nel salvataggio su file", e);
        }
    }

    @Override
    public void update(Course course) throws EntityNotFoundException {

    }

    @Override
    public void deleteById(long id) throws EntityNotFoundException {

    }

    public String courseToCSV(Course c){
        return String.format("%d,%s,%s,%s,%f", c.getId(), c.getTitle(), c.getDescription(),
                c.getProgram(), c.getDuration());
    }
}
