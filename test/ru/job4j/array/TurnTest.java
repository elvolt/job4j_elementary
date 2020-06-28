package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {

    @Test
    public void backForEvenElements() {
        int[] input = new int[] {1, 2, 3, 4};
        int[] expected = new int[] {4, 3, 2, 1};
        int[] out = Turn.back(input);
        assertThat(out, is(expected));
    }

    @Test
    public void backForOddElements() {
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] expected = new int[] {5, 4, 3, 2, 1};
        int[] out = Turn.back(input);
        assertThat(out, is(expected));
    }
}