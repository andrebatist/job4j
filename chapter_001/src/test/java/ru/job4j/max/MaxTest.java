package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 14.10.2018
 */
public class MaxTest {

    /**
     * Test when 1 and 2.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test when 3 and 1.
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 1);
        assertThat(result, is(3));
    }

    /**
     * Test when 4 and 4.
     */
    @Test
    public void whenFirstEqualsSecond() {
        Max maxim = new Max();
        int result = maxim.max(4, 4);
        assertThat(result, is(4));
    }

    /**
     * Test when 1 2 and 3.
     */
    @Test
    public void whenMaxFromOneTwoThree() {
        Max maxim = new Max();
        int result  = maxim.max(1,2,3);
        assertThat(result, is(3));
    }

    /**
     * Test when 3 2 and 1.
     */
    @Test
    public void whenMaxFromThreeTwoOne() {
        Max maxim = new Max();
        int result  = maxim.max(3,2,1);
        assertThat(result, is(3));
    }

    /**
     * Test when 3 3 and 3.
     */
    @Test
    public void whenMaxFromThreeAreEqual() {
        Max maxim = new Max();
        int result  = maxim.max(3,3,3);
        assertThat(result, is(3));
    }
}