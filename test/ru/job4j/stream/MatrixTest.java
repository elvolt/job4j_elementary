package ru.job4j.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void testModifyMatrix() {
        Integer[][] matrix = {{1, 2}, {3, 4}, {7, 8}};
        Matrix translator = new Matrix();
        List<Integer> rsl = translator.modifyMatrix(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 7, 8);
        assertThat(rsl, is(expected));
    }
}