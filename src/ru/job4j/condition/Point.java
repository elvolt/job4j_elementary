package ru.job4j.condition;

public class Point {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result1 = Point.distance(1, 2, 3, 4);
        double result2 = Point.distance(-1, 2, 2, -1);
        double result3 = Point.distance(2, 3, 1, 4);
        double result4 = Point.distance(6, 4, -3, -2);
        System.out.println("result (1, 2) to (3, 4) " + result1);
        System.out.println("result (-1, 2) to (2, -1) " + result2);
        System.out.println("result (2, 3) to (1, 4) " + result3);
        System.out.println("result (6, 4) to (-3, -2) " + result4);
    }

}
