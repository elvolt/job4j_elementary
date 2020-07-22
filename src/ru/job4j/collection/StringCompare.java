package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            rst = Character.compare(left.charAt(index), right.charAt(index));
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(left.length(), right.length());
        }
        return rst;
    }
}