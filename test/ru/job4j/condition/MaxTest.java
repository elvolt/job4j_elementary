package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenLeftMoreThanRightThenLeft() {
        int left = 3;
        int right = 2;
        int result = Max.max(left, right);
        assertThat(result, is(left));
    }

    @Test
    public void whenRightMoreThanLeftThenRight() {
        int left = -1;
        int right = 2;
        int result = Max.max(left, right);
        assertThat(result, is(right));
    }

    @Test
    public void whenLeftEqualsRightThenLeft() {
        int left = 3;
        int right = 3;
        int result = Max.max(left, right);
        assertThat(result, is(left));
    }

    @Test
    public void maxWithThreeNumbers() {
        int first = 3;
        int second = 5;
        int third = -1;
        int result = Max.max(first, second, third);
        assertThat(result, is(second));
    }
}