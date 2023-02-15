package org.generation.italy.codeSchool.model.data.implementations;

import org.generation.italy.codeSchool.model.Course;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.*;

class CSVFileCourseRepositoryTest {
    private static final long ID = 1;
    private static final String TITLE = "TITLE";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PROGRAM = "PROGRAM";
    private static final double DURATION = 200.0;

    private static final String CSV_LINE = String.format("%d,%s,%s,%s,%f", ID, TITLE, DESCRIPTION, PROGRAM, DURATION);
    private static final String FILENAME = "TestData.csv";

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Setup");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @org.junit.jupiter.api.Test
    void findById() {
        System.out.println("findById");
    }

    @org.junit.jupiter.api.Test
    void create() {
        System.out.println("create");
        out.println("ciao");
    }

    @org.junit.jupiter.api.Test
    void courseToCSV() {
        // ARRANGE
        Course c = new Course(ID, TITLE, DESCRIPTION, PROGRAM, DURATION);
        CSVFileCourseRepository repo = new CSVFileCourseRepository(FILENAME);
        // ACT
        String csvLine = repo.courseToCSV(c);
        // ASSERT
        assertEquals(CSV_LINE, csvLine);
    }
}