package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenPoint1EqualsPoint2ThenZero() {
        int x1 = 3;
        int y1 = 4;
        int x2 = 3;
        int y2 = 4;
        double expected = 0;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenPoint1NotEqualsPoint2ThenMoreThanZero() {
        int x1 = 1;
        int y1 = 4;
        int x2 = 2;
        int y2 = -1;
        double expected = 5.1;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.01);
    }
}