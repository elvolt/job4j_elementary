package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(Fact.calc(0));
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n shouldn't be negative");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
