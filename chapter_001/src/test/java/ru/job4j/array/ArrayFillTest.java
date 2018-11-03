package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class ArrayFillTest {
    /**
     * Test массив с минимальным элементом первый 2 элемента.
     */
    @Test
    public void whenSortArrayWithTwoElementsMinLeft() {
        ArrayFill arrayFill = new ArrayFill();
        int[] rst = arrayFill.fill(new int[]{1, 3}, new int[]{2, 4});
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(rst, is(expect));
    }

    /**
     * Test массив с минимальным элементом второй 2 элемента.
     */
    @Test
    public void whenSortArrayWithTwoElementsMinRight() {
        ArrayFill arrayFill = new ArrayFill();
        int[] rst = arrayFill.fill(new int[]{2, 4}, new int[]{1, 3});
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(rst, is(expect));
    }

    /**
     * Test массив с минимальным элементом первый 4 элемента.
     */
    @Test
    public void whenSortArrayWithFourElementsMinLeft() {
        ArrayFill arrayFill = new ArrayFill();
        int[] rst = arrayFill.fill(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(rst, is(expect));
    }

    /**
     * Test массив с минимальным элементом второй 4 элемента.
     */
    @Test
    public void whenSortArrayWithFourElementsMinRight() {
        ArrayFill arrayFill = new ArrayFill();
        int[] rst = arrayFill.fill(new int[]{2, 4, 6, 8}, new int[]{1, 3, 5, 7});
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(rst, is(expect));
    }
}