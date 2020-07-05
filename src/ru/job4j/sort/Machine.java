package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private static final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int change = money - price;
        for (int elem : COINS) {
            while (change - elem >= 0) {
                rsl[size] = elem;
                size += 1;
                change -= elem;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
