package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Deps = o1.split("/");
        String[] o2Deps = o2.split("/");
        int rsl = o2Deps[0].compareTo(o1Deps[0]);
        if (rsl != 0) {
            return rsl;
        }
        int length1 = o1Deps.length;
        int length2 = o2Deps.length;
        for (int i = 1; i < Math.min(length1, length2); i++) {
            if (o1Deps[i].equals(o2Deps[i])) {
                continue;
            }
            rsl = o1Deps[i].compareTo(o2Deps[i]);
            break;
        }
        if (rsl == 0 && length1 != length2) {
            rsl = length1 - length2;
        }
        return rsl;
    }
}
