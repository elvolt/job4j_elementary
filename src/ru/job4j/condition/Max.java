package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return left >= right ? left : right;
    }

    public static int max(int first, int second, int third) {
        return max(
          first,
          max(second, third)
        );
    }

    public static void main(String[] args) {
        System.out.println(Max.max(34, 21));
    }
}
