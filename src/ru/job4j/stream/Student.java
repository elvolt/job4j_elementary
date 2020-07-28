package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Student {

    private int score;
    private String surname;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public Student(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", surname='" + surname + '\''
                + '}';
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Ivanov", 40),
                new Student("Petrov", 60),
                new Student("Sidorov", 70),
                new Student("Smirnov", 85)
        );
        System.out.println(
                students.stream()
                        .collect(
                                Collectors.toMap(
                                        Student::getSurname,
                                        student -> student
                                )
                        )
        );
    }
}