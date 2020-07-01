package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DefragmentTest {

    @Test
    public void whenSwap3to1() {
        String[] input = {"H", "l", "l", "e", "o"};
        String[] expect = {"H", "e", "l", "l", "o"};
        String[] rsl = Defragment.swap(input, 3, 1);
        assertThat(rsl, Matchers.is(expect));
    }

    @Test
    public void singleFirstNull() {
        String[] input = {null, "I"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void notFirstNull() {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void firstNull() {
        String[] input = {null, "I", "wanna", null, "be", null, "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void notAllNull() {
        String[] input = {null, null, null};
        String[] compressed = Defragment.compress(input);
        String[] expected = {null, null, null};
        assertThat(compressed, is(expected));
    }

    @Test
    public void notAllAtFirstNull() {
        String[] input = {null, null, null, "I", "wanna", "be", "compressed"};
        String[] compressed = Defragment.compress(input);
        String[] expected = {"I", "wanna", "be", "compressed", null, null, null};
        assertThat(compressed, is(expected));
    }
}