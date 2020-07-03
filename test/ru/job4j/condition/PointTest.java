package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenPoint1EqualsPoint2ThenZero() {
        Point point1 = new Point(3, 4);
        Point point2 = new Point(3, 4);
        double expected = 0;
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenPoint1NotEqualsPoint2ThenMoreThanZero() {
        Point point1 = new Point(1, 4);
        Point point2 = new Point(2, -1);
        double expected = 5.1;
        double out = point1.distance(point2);
        Assert.assertEquals(expected, out, 0.01);
    }
}