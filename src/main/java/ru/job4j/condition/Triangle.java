package ru.job4j.condition;

public class Triangle {
    public static boolean exist(double ab, double ac, double bc) {
        return ab + bc > bc && ac + bc > ab && ab + bc > ac;
    }

    public static void main(String[] args) {
        System.out.println("Треугольник со сторонами 2, 2, 2 существует: " + Triangle.exist(2.0, 2.0, 2.0));
    }
}
