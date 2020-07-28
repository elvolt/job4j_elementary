package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, -123, 4, -5, 8, 13);
        List<Integer> positiveNums = list.stream().filter(item -> item > 0).collect(Collectors.toList());
        positiveNums.forEach(System.out::println);
    }
}
