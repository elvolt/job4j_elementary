package ru.job4j.loop;

public class CheckPrimeNumber {
    public static boolean check(int number) {
        if (number < 2) {
            return false;
        }
        boolean prime = true;
        for (int i = 2; i < number; i += 1) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
