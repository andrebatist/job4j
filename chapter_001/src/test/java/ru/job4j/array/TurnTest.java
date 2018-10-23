package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 23.10.2018
 */
public class TurnTest {
    /**
     * Test на массив из 4 элементов.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Test на массив из 3 элементов.
     */
    @Test
    public void whenTurnArrayWithUnEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6};
        int[] result = turner.back(input);
        int[] expect = new int[]{6, 1, 4};
        assertThat(result, is(expect));
    }
}