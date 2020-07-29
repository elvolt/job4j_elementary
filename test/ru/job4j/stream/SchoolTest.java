package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void testCollectA() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Ivanov", 70),
                new Student("Ivanov", 85)
        );
        School school = new School();
        List<Student> classA = school.collect(
                students,
                student -> student.getScore() >= 70 && student.getScore() <= 100
        );
        List<Student> expected = Arrays.asList(
                new Student("Ivanov", 70),
                new Student("Ivanov", 85)
        );
        assertThat(classA, is(expected));
    }

    @Test
    public void testCollectB() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Sidorov", 50),
                new Student("Ivanov", 85)
        );
        School school = new School();
        List<Student> classB = school.collect(
                students,
                student -> student.getScore() >= 50 && student.getScore() < 70
        );
        List<Student> expected = Arrays.asList(
                new Student("Petrov", 60),
                new Student("Sidorov", 50)
        );
        assertThat(classB, is(expected));
    }

    @Test
    public void testCollectC() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Sidorov", 30),
                new Student("Ivanov", 85)
        );
        School school = new School();
        List<Student> classC = school.collect(
                students,
                student -> student.getScore() > 0 && student.getScore() < 50
        );
        List<Student> expected = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Sidorov", 30)
        );
        assertThat(classC, is(expected));
    }

    @Test
    public void testGetStudentsMap() {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Sidorov", 30),
                new Student("Ivanov", 85)
        );
        School school = new School();
        Map<String, Student> result = school.getStudentsMap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Ivanov", new Student("Ivanov", 40));
        expected.put("Petrov", new Student("Petrov", 60));
        expected.put("Sidorov", new Student("Sidorov", 30));
        assertThat(result, is(expected));
    }
}