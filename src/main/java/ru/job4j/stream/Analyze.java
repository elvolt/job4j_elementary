package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        OptionalDouble average =  stream.flatMap(
                pupil -> pupil.getSubjects().stream()
                .map(Subject::getScore)
        ).mapToInt(subject -> subject)
                .average();
        return average.orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> {
            String name = pupil.getName();
            List<Subject> subjects = pupil.getSubjects();
            OptionalDouble average = subjects.stream()
                    .map(Subject::getScore)
                    .mapToInt(subjectScores -> subjectScores)
                    .average();
            if (average.isPresent()) {
                return new Tuple(name, average.getAsDouble());
            }
            return new Tuple(name, 0D);
        }).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        Optional<Tuple> max = stream.map(pupil -> {
            double sum = pupil.getSubjects()
                    .stream()
                    .mapToInt(Subject::getScore)
                    .sum();
            return new Tuple(pupil.getName(), sum);
        }).max(Comparator.comparingDouble(Tuple::getScore));
        return max.orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore)).orElse(null);
    }
}