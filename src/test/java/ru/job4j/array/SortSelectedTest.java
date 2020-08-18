package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortSelectedTest {
    @Test
    public void whenSortWith5Numbers() {
        int[] input = new int[] {3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortWith3Numbers() {
        int[] input = new int[] {8, 5, 7};
        int[] result = SortSelected.sort(input);
        int[] expect = new int[] {5, 7, 8};
        assertThat(result, is(expect));
    }
}