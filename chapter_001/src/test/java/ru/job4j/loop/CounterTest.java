package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 18.10.2018
 */
public class CounterTest {

    /**
     * Test на подсчет суммы четных чисел в диапазоне от 1 до 10.
     */
    @Test
    public void countSumFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}