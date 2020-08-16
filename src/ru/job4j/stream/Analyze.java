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
        List<Pupil> pupils = stream.collect(Collectors.toList());
        int studentsCount = pupils.size();
        List<Subject> subjects = pupils.stream()
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.toList());
        Stream<String> uniqSubjectsNames = subjects.stream()
                .map(Subject::getName)
                .distinct();

        return uniqSubjectsNames.map(name -> {
                  double scoresSum = subjects.stream()
                          .filter(subject -> subject.getName().equals(name))
                          .mapToInt(Subject::getScore)
                            .sum();
                  return new Tuple(name, scoresSum / studentsCount);
                }).collect(Collectors.toList());
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
        List<Subject> subjects = stream.flatMap(
                pupil -> pupil.getSubjects().stream()
        ).collect(Collectors.toList());
        Stream<String> uniqSubjectsNames = subjects.stream()
                .map(Subject::getName)
                .distinct();
        Optional<Tuple> max = uniqSubjectsNames.map(n -> {
            double scoresSum = subjects.stream()
                    .filter(subject -> subject.getName().equals(n))
                    .mapToInt(Subject::getScore)
                    .sum();
            return new Tuple(n, scoresSum);
        }).max(Comparator.comparingDouble(Tuple::getScore));
        return max.orElse(null);
    }
}