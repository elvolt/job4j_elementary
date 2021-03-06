package ru.job4j.condition;

public class MultiMax {
    public static int max(int first, int second, int third) {
        int max = first >= second ? first : second;
        max = max >= third ? max : third;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max between 3, 5, 4 is " + MultiMax.max(3, 5, 4));
    }
}
