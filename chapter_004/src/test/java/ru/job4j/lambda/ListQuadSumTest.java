package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 22.01.2019
 */
public class ListQuadSumTest {
    /**
     * Тест на список 1-4
     */
    @Test
    public void whenListThenSum() {
        int result = new ListQuadSum().getSumQuadro(List.of(1, 2, 3, 4));
        int expected = 20;
        assertThat(result, is(expected));
    }
}