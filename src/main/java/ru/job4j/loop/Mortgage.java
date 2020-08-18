package ru.job4j.loop;

public class Mortgage {
    public static int year(int amount, int salary, double percent) {
        int years = 1;
        double rest = amount * (1 + percent / 100);
        while (rest > salary) {
            years += 1;
            rest = (rest - salary) * (1 + percent / 100);
        }
        return years;
    }
}